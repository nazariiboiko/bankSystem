package com.example.banksystem.service;

import com.example.banksystem.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User get(Long id);
    User save(User user);
    User update(User user);
    void delete(User user);
    UserDetails loadUserByPhoneNumber(String phoneNumber) throws UsernameNotFoundException;
}