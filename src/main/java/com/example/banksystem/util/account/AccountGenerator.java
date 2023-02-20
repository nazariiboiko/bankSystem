package com.example.banksystem.util.account;

import com.example.banksystem.entity.Currency;

import java.util.Random;

public class AccountGenerator {
    public static String generateAccountNumber(Long id, Currency currency) {
        StringBuilder number = new StringBuilder();
        Random randomizer = new Random();
        int size = 0;
        switch (currency) {
            case EUR -> number.append(5867);
            case UAH -> number.append(1111);
            case USD -> number.append(9999);
        }
        number.append(id);
        size = number.length();
        for(int i = 0; i < 16 - size; i++) {
            number.append(randomizer.nextInt(9));
        }
        return number.toString();
    }
}
