package com.example.banksystem.repository;

import com.example.banksystem.entity.Role;
import com.example.banksystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String phoneNumber);
    @Modifying
    @Query(value = "update User u set u.id = ?1 u.login = ?2, u.password = ?3, u.firstName =?4, u.lastName = ?5, u.age = ?6, u.email = ?7, u.role = ?8, u.isActive = ?9 where u.id = ?1", nativeQuery = true)
    User update(Long id, String login, String password, String firstName, String lastName, Integer age, String email, Role role, Boolean active);
}
