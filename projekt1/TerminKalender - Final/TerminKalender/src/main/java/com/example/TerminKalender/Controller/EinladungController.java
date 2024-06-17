package com.example.TerminKalender.Controller;

import com.example.TerminKalender.Model.Einladung;
import com.example.TerminKalender.Model.EinladungInformation;
import com.example.TerminKalender.Service.EinladungService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/einladung")
public class EinladungController {

    @Autowired
    private EinladungService einladungService;

    //Create Einladung
    @PostMapping("")
    public ModelAndView createEinladung(Einladung einladung, BindingResult bindingResult){

        einladungService.createEinladung(einladung);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/TerminKalenderPage");
        return modelAndView;
    }

    // Decline Einladung
    @PostMapping("/decline")
    public ModelAndView declineEinladung(EinladungInformation einladungInformation, BindingResult bindingResult){

        einladungService.declineEinladung(einladungInformation.getEinladungsId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/TerminKalenderPage");
        return modelAndView;
    }

    // Accept Einladung
    @PostMapping("/accept")
    public ModelAndView accpetEinladung(EinladungInformation einladungInformation, BindingResult bindingResult, HttpSession session){

        einladungService.acceptEinladung(einladungInformation,session);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/TerminKalenderPage");
        return modelAndView;
    }
}
