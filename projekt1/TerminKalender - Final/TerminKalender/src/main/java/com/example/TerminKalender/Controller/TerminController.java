package com.example.TerminKalender.Controller;

import com.example.TerminKalender.Model.Termin;
import com.example.TerminKalender.Service.TerminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/termin")
public class TerminController {

    @Autowired
    TerminService terminService;

    // Create Termin
    @PostMapping("")
    public ModelAndView createTermin(Termin termin, BindingResult bindingResult , HttpSession session){

        terminService.craeteTermin(termin,session);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/TerminKalenderPage");
        return modelAndView;
    }

    // Delete Termin
    @PostMapping("/delete")
    public ModelAndView deleteTermin(Termin termin, BindingResult bindingResult){

        terminService.deleteTermin(termin);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/TerminKalenderPage");
        return modelAndView;
    }

    // Load EditTerminPage
    @PostMapping("/editTerminPage")
    public String loadEditTermin(Termin termin, BindingResult bindingResult, Model model, HttpSession session){

        termin.setErstellerId((Long) session.getAttribute("userID"));

        model.addAttribute("termin", termin);
        return "EditPage";
    }

    // Update Termin
    @PostMapping("/update")
    public ModelAndView updateTermin(Termin termin, BindingResult bindingResult, Model model){
        terminService.updateTermin(termin);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/TerminKalenderPage");
        return modelAndView;
    }



}
