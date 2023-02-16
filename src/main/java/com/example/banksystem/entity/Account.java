package com.example.banksystem.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Table(name = "accounts", uniqueConstraints={@UniqueConstraint(columnNames={"account_number"})})
@Getter
@Setter
public class Account {

    @Id
    @Column(name="id",updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "account_number", nullable = false)
    @NotBlank
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name ="currency", nullable = false)
    @NotNull
    private Currency currency;

    @Column(name = "balance", nullable = false)
    @NotNull
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @BooleanFlag
    @Column(name = "active", nullable = false)
    @NotNull
    private boolean isActive;

    public Account(){}

    public Account(Long id, String name, String accountNumber, Currency currency, BigDecimal balance, User user, boolean isActive) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
        this.user = user;
        this.isActive = isActive;
    }
}
