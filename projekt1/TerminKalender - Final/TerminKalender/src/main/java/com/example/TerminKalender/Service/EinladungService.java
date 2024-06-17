package com.example.TerminKalender.Service;

import com.example.TerminKalender.Model.Einladung;
import com.example.TerminKalender.Model.EinladungInformation;
import com.example.TerminKalender.Model.Termin;
import com.example.TerminKalender.Repository.EinladungRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EinladungService {

    @Autowired
    private EinladungRepository einladungRepository;
    @Autowired
    private TerminService terminService;
    @Autowired
    private UserService userService;


    // Decline Einladung
    public void declineEinladung(Long id){
        einladungRepository.deleteById(id);
    }

    // Accept Einladung
    public void acceptEinladung(EinladungInformation einladungInformation,HttpSession session) {

        // Accept Einladung erfolgt in dem ein neuer Termin für den User erstellt wird
        Termin termin = new Termin(einladungInformation.getTag(),
                einladungInformation.getMonat(),
                einladungInformation.getJahr(),
                einladungInformation.getUhrzeit(),
                einladungInformation.getBeschreibung());

        terminService.craeteTermin(termin,session);

        // Delete accpeted einladung
        einladungRepository.deleteById(einladungInformation.getEinladungsId());

    }

    // Create Einladung
    public void createEinladung(Einladung einladung){
        einladungRepository.save(einladung);
    }


    // Holt alle Einladungen für den eingeloggten Benutzer anhand der invitedId
    // Zuerst werden alle Einladungen des Benutzers abgerufen, dann wird für jede Einladung der entsprechende Termin abgerufen,
    // um die relevanten Termin-Informationen in eine EinladungInformation zu überführen.
    public List<EinladungInformation> getAllEinladungenByinvitedId(HttpSession session){

        Long userId = (Long) session.getAttribute("userID");
        List<Einladung> einladungen = einladungRepository.findAllByinvitedId(userId);

        List<EinladungInformation> einladungInformations = new ArrayList<>();

        Optional<Termin> termin ;

        for (Einladung einladung : einladungen){

            termin = terminService.getTerminById(einladung.getTerminId());

            if(termin.isPresent()) {

                einladungInformations.add(new EinladungInformation(
                        termin.get().getId(),
                        termin.get().getTag(),
                        termin.get().getMonat(),
                        termin.get().getJahr(),
                        termin.get().getUhrzeit(),
                        termin.get().getBeschreibung(),
                        termin.get().getId(),
                        userService.getNameByUserId( termin.get().getErstellerId()),
                        einladung.getId()
                ));
            }
        }

        return einladungInformations;
    }


}
