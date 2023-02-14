package com.example.banksystem.service;

import com.example.banksystem.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account get(Long id);
    Account save(Account account);
    Account update(Account account);
    void delete(Account account);
}
