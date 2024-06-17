package com.example.TerminKalender.Controller;

import org.springframework.ui.Model;
import com.example.TerminKalender.Model.LoginModel;
import com.example.TerminKalender.Model.User;
import com.example.TerminKalender.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    //Load LoginPage
    @GetMapping("/login")
    public String loadLoginPage(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "LoginPage";
    }

    // Process Login
    @PostMapping("/processlogin")
    public ModelAndView loginUser(LoginModel loginmodel, BindingResult bindingResult, HttpSession session) {

        User usercheck = userService.getUserbyname(loginmodel.getUsername());
        ModelAndView modelAndView = new ModelAndView();

        //check existing User
        if(usercheck == null){
            modelAndView.addObject("errorMessage", "Benutzer oder Password falsch.");
            modelAndView.addObject("loginModel", new LoginModel());
            modelAndView.setViewName("LoginPage");
            return modelAndView;
        }

        // check matching Password
        if(!Objects.equals(usercheck.getPassword(), loginmodel.getPassword())){
            modelAndView.addObject("errorMessage", "Benutzer oder Password falsch.");
            modelAndView.addObject("loginModel", new LoginModel());
            modelAndView.setViewName("LoginPage");
            return modelAndView;
        }

        // login valid
        else{
            session.setAttribute("userID", usercheck.getId());
            modelAndView.setViewName("redirect:/TerminKalenderPage");
            return modelAndView;
        }
    }

}
