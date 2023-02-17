package com.example.banksystem.repository;

import com.example.banksystem.entity.User;
import com.example.banksystem.security.UserDetailsServiceImpl;
import com.example.banksystem.service.UserService;
import com.example.banksystem.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
public class UserRepositoryTest {

    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByIdTest() {
        User user = userRepository.findByLogin("380971137339").orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        System.out.println(user.getFirstName());
        System.out.println(user.getPassword());
    }
}
