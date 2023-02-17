package com.example.banksystem.security;

import com.example.banksystem.entity.User;
import com.example.banksystem.repository.UserRepository;
import com.example.banksystem.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(phoneNumber).orElseThrow(() ->
                new UsernameNotFoundException("User not found: " + phoneNumber));
        return SecurityUser.fromUser(user);
    }
}
