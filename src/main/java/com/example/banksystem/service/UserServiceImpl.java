package com.example.banksystem.service;

import com.example.banksystem.entity.User;
import com.example.banksystem.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        userRepository.update(user.getId(), user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getAge(), user.getEmail(), user.getRole(), user.isActive());
        return user;
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        delete(get(id));
    }

    @Override
    public User getByPhoneNumber(String phoneNumber) {
        return userRepository.findByLogin(phoneNumber).orElseThrow(() ->
                new UsernameNotFoundException("User not found: " + phoneNumber));
    }
}
