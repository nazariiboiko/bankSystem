package com.example.banksystem.service;

import com.example.banksystem.entity.Account;
import com.example.banksystem.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account get(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent())
            return account.get();
        return null;
    }

    @Override
    @Transactional
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void delete(Account account) {
        accountRepository.delete(account);
    }
}
