package com.example.banksystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account_histories")
@Data
public class AccountHistory {
    @Id
    @Column(name="id",updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sender_account_id", nullable = false)
    private Long senderAccountId;

    @Column(name="receiver_account_id", nullable = false)
    private Long receiverAccountId;

    @Column(name="operation_time", nullable = false)
    private Date operationTime = new Date();

    @Column(name = "sender_currency", nullable = false)
    private Currency senderCurrency;

    @Column(name = "receiver_currency", nullable = false)
    private Currency recipientCurrency;

    @Column(name="commission", nullable = false)
    private BigDecimal commission;


    @Column(name="message")
    private String message;

    public AccountHistory() {}

    public AccountHistory(Long id, Long senderAccountId, Long receiverAccountId, Date operationTime, Currency senderCurrency, Currency recipientCurrency, BigDecimal commission, String message) {
        this.id = id;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.operationTime = operationTime;
        this.senderCurrency = senderCurrency;
        this.recipientCurrency = recipientCurrency;
        this.commission = commission;
        this.message = message;
    }
}
