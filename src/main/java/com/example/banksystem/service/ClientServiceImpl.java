package com.example.banksystem.service;

import com.example.banksystem.entity.Client;
import com.example.banksystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client get(Long id) {
        return null;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client user) {
        return null;
    }

    @Override
    public void delete(Client user) {

    }
}
