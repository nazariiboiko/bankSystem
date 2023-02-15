package com.example.banksystem.service;

import com.example.banksystem.entity.Account;
import com.example.banksystem.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client get(Long id);
    Client save(Client user);
    Client update(Client user);
    void delete(Client user);
}
