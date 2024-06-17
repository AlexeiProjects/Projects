package com.example.TerminKalender.Controller;

import com.example.TerminKalender.Model.Einladung;
import com.example.TerminKalender.Model.EinladungInformation;
import com.example.TerminKalender.Model.Termin;
import com.example.TerminKalender.Model.User;
import com.example.TerminKalender.Service.EinladungService;
import com.example.TerminKalender.Service.SortService;
import com.example.TerminKalender.Service.TerminService;
import com.example.TerminKalender.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private TerminService terminService;

    @Autowired
    private UserService userService;

    @Autowired
    private SortService sortService;

    @Autowired
    private EinladungService einladungService;

    //Load HomePage
    @GetMapping("/")
    public String loadhome(){
        return "HomePage";
    }


    //Load TerminPage
    @GetMapping("/TerminKalenderPage")
    public String loadTerminKalender(Model model, HttpSession session){

        List<Termin> termine = terminService.getallTerminebyUserId(session);
        termine = sortService.sortByDate(termine);

        List<User> users = userService.getallUsers();

        List<EinladungInformation> einladungInformations = einladungService.getAllEinladungenByinvitedId(session);

        model.addAttribute("einladungen", einladungInformations);
        model.addAttribute("termine", termine);
        model.addAttribute("users", users);
        model.addAttribute("einladungForm", new Einladung());
        return "TerminPage";
    }

    //Load CreateTerminPage
    @GetMapping("/createTermin")
    public String loadCreateTermin(Model model){

        model.addAttribute("termin", new Termin());
        return "CreateTerminPage";
    }

}
