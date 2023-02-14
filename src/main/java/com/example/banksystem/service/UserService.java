package com.example.banksystem.service;

import com.example.banksystem.entity.Account;
import com.example.banksystem.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User get(Long id);
    User save(User user);
    User update(User user);
    void delete(User user);
}
