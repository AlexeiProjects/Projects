package com.example.TerminKalender.Service;

import com.example.TerminKalender.Model.Termin;
import com.example.TerminKalender.Repository.TerminRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TerminService {
    @Autowired
    private TerminRepository terminRepository;


    // Create Termin
    public void craeteTermin(Termin termin, HttpSession session){
        Long userId = (Long) session.getAttribute("userID");
        termin.setErstellerId(userId);
        terminRepository.save(termin);
    }

    // Get all Termine
    public List<Termin> getallTermine(){
        List<Termin> termine = new ArrayList<Termin>(terminRepository.findAll());
        return termine;
    }

    // Get all Termine by UserId
    public List<Termin> getallTerminebyUserId(HttpSession session){
        List<Termin> termine = new ArrayList<Termin>(terminRepository.findAllByerstellerId((Long) session.getAttribute("userID")));
        return termine;
    }


    // Delete Termin
    public void deleteTermin(Termin termin){
        terminRepository.deleteById(termin.getId());
    }

    // Update Termin
    public void updateTermin(Termin termin){

        terminRepository.save(termin);
    }

    // Get Termin by Id
    public Optional<Termin> getTerminById(Long id){
        return terminRepository.findById(id);
    }

}
