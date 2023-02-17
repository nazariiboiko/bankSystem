package com.example.banksystem.service;

import com.example.banksystem.security.SecurityUser;
import com.example.banksystem.entity.User;
import com.example.banksystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User save(User client) {
        return userRepository.save(client);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
