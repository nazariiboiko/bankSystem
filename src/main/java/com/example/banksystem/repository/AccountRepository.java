package com.example.banksystem.repository;

import com.example.banksystem.entity.Account;
import com.example.banksystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByUser(User user);
    @Modifying
    @Query(value = "UPDATE accounts SET active='false' WHERE id=?1", nativeQuery = true)
    void blockAccount(Long id);

    @Modifying
    @Query(value = "UPDATE accounts SET balance=?2 WHERE id=?1", nativeQuery = true)
    void replenish(Long id, BigDecimal value);
}
