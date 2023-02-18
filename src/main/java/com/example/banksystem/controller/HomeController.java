package com.example.banksystem.controller;

import com.example.banksystem.entity.User;
import com.example.banksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String greetingsPage() {
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Authentication authentication, Model model) {
        User user = userService.getByPhoneNumber(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("date", user.getRegistered().getTime());
        return "home";
    }
}
