package com.example.banksystem.repository;

import com.example.banksystem.entity.Account;
import com.example.banksystem.entity.Currency;
import com.example.banksystem.entity.User;
import com.example.banksystem.security.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findByIdTest() {
        User user = userRepository.findByLogin("380971137339").orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        System.out.println(user.getFirstName());
        System.out.println(user.getPassword());
    }

    @Test
    public void accontRepositoryFindByUserTest() {
        User user = userRepository.getReferenceById(352L);
        List<Account> list = accountRepository.findAllByUser(user);
        Assertions.assertFalse(list.isEmpty());
        list.stream().forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void saveAccountTest()
    {
        User user = userRepository.getReferenceById(2L);

        Account account = new Account();
        account.setId(-1L);
        account.setName("Test");
        account.setAccountNumber("123");
        account.setUser(user);
        account.setBalance(BigDecimal.valueOf(0));
        account.setCurrency(Currency.EUR);
        account.setActive(true);

        accountRepository.save(account);
    }
}
