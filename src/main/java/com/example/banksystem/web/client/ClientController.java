package com.example.banksystem.web.client;

import com.example.banksystem.entity.Client;
import com.example.banksystem.entity.Role;
import com.example.banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String accountList(Model model) {
        model.addAttribute("userList", clientService.getAll());
        return "userList";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "userCreateForm";
    }

    @PostMapping
    public String addUser(@ModelAttribute("client") Client client) {
        System.out.println(client.getFirstName() + " " + client.getLastName());
        clientService.save(client);
        return "redirect:/clients";
    }
}
