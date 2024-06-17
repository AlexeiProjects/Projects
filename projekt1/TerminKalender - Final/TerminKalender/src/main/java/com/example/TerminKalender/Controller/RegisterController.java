package com.example.TerminKalender.Controller;

import com.example.TerminKalender.Model.LoginModel;
import com.example.TerminKalender.Model.RegisterModel;
import com.example.TerminKalender.Model.User;
import com.example.TerminKalender.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    // Load RegisterPage
    @GetMapping("/register")
    public String loadRegisterPage(Model model){
        model.addAttribute("registerModel", new RegisterModel());
        return "RegisterPage";
    }


    // Process Register
    @PostMapping("/processregister")
    public String registerUser(@Valid @ModelAttribute("registerModel") RegisterModel registerModel, BindingResult bindingResult, Model model) {

        //InValid Register values
        if(bindingResult.hasErrors()){
            model.addAttribute("registerModel", registerModel);
            return "RegisterPage";
        }

        User neuerUser = new User(registerModel.getUsername(),registerModel.getPassword());
        userService.createUser(neuerUser);

        model.addAttribute("loginModel", new LoginModel());
        return "LoginPage";
    }
}
