package com.example.banksystem.entity;

import com.example.banksystem.entity.Role;
import com.example.banksystem.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void userConstructorTest() {
        User user = new User(
                "380971137338",
                "nazar12345",
                "Nazarii",
                "Boiko",
                20,
                "nazarii.boiko2@gmail.com", Role.ROLE_DEVELOPER);

        user.setAccounts(List.of());
        user.setRegistered(new Date(2000));

        Assertions.assertEquals(user.getLogin(), "380971137338");
        Assertions.assertEquals(user.getPassword(), "nazar12345");
        Assertions.assertEquals(user.getFirstName(), "Nazarii");
        Assertions.assertEquals(user.getLastName(), "Boiko");
        Assertions.assertEquals(user.getAge(), 20);
        Assertions.assertEquals(user.getEmail(), "nazarii.boiko2@gmail.com");
        Assertions.assertEquals(user.getRole(), Role.ROLE_DEVELOPER);
        Assertions.assertEquals(user.getAccounts(), List.of());
        Assertions.assertEquals(user.getRegistered(), new Date(2000));
    }

    @Test
    public void userEqualsTest() {
        User user = new User();
        User user2 = new User();
        Assertions.assertEquals(user, user);
        Assertions.assertEquals(user, new User());
        Assertions.assertEquals(user, user2);
        Assertions.assertEquals(user, user);
    }
}
