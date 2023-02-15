package com.example.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    @NotBlank
    private String login;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "age", nullable = false)
    @NumberFormat
    private Integer age;

    @Column(name = "email", nullable = true)
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "registered")
    private Date registered = new Date();

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Account> accounts;

    public Client(String login, String password, String firstName, String lastName, Integer age, String email, Role role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public Client(){}

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null || o.getClass() != this.getClass())
            return false;

        Client user = (Client) o;

        return this.getId().equals(user.getId());

    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}
