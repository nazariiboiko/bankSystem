package com.example.banksystem.service;

import com.example.banksystem.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    List<Account> getAll();
    List<Account> getAllByUserId(Long id);
    Account get(Long id);
    Account save(Account account);
    Account update(Account account);
    void delete(Long id);
    void block(Long id);
    void replenish(Long id, BigDecimal value);
}
