package com.cydeo.lab04springmvc.service.impl.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String profileView(Model model){
        model.addAttribute("profile",new Profile("mike@gmail.com","8573089889","Mike","Ozborn","ozzy", LocalDateTime.now()));
        return "/profile/profile-info";
    }
}
