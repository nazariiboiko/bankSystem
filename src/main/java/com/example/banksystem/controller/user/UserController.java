package com.example.banksystem.controller.user;

import com.example.banksystem.entity.User;
import com.example.banksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String accountList(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "userList";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("client", user);
        return "userCreateForm";
    }

    @PostMapping
    public String addUser(@ModelAttribute("client") User client) {
        userService.save(client);
        return "redirect:/users";
    }
}
