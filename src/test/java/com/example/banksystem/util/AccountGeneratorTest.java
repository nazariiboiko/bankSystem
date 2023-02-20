package com.example.banksystem.util;

import com.example.banksystem.entity.Currency;
import com.example.banksystem.util.account.AccountGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountGeneratorTest {

    @Test
    public void generateAccountNumberTest() {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 100000; i++) {
            String res = AccountGenerator.generateAccountNumber(592L, Currency.EUR);
            list.add(res);
        }
        for(int i = 0; i < 2000; i++) {
            String res = AccountGenerator.generateAccountNumber(592L, Currency.EUR);
            Assertions.assertFalse(list.contains(res));
        }
        list.stream().forEach(p -> Assertions.assertEquals(16, p.length()));
    }
}
