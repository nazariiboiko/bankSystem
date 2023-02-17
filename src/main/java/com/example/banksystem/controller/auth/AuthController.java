package com.example.banksystem.controller.auth;

import com.example.banksystem.service.UserService;
import com.example.banksystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getLoginPage() {
        return "loginForm";
    }

//    @PostMapping
//    public String validateUser() {
//        throw new UnsupportedOperationException();
//    }
}
