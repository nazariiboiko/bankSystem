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
        user.setActive(true);
        user.setId(Long.valueOf(-1));
        model.addAttribute("user", user);
        return "userCreateForm";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("client") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/details/{id}")
    public String getInfo(@PathVariable("id") Long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        model.addAttribute("date", user.getRegistered().getTime());
        return "home";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "userEditForm";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("client") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/block/{id}")
    public String blockUser(@PathVariable("id") Long id) {
        User user = userService.get(id);
        user.setActive(false);
        userService.save(user);
        return "redirect:/users";
    }
}
