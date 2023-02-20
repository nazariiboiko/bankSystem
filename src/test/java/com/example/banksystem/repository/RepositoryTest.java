package com.example.banksystem.repository;

import com.example.banksystem.entity.Account;
import com.example.banksystem.entity.User;
import com.example.banksystem.security.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@SpringBootTest
public class RepositoryTest {

    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();

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
}
