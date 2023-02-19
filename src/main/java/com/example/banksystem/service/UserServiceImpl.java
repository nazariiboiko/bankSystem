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
    public User update(Long id, User user) {
        User ent = get(id);
        ent.setFirstName(user.getFirstName());
        ent.setLastName(user.getLastName());
        ent.setAge(user.getAge());
        ent.setActive(user.isActive());
        ent.setEmail(user.getEmail());
        ent.setLogin(user.getLogin());
        ent.setPassword(user.getPassword());
        ent.setRole(user.getRole());
        save(ent);
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
