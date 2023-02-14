package com.example.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @NotBlank
    private Integer age;

    @Column(name = "email", nullable = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @NotBlank
    private Role role;

    @Column(name = "registered")
    private Date registered = new Date();

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Account> accounts;

    public User(String login, String password, String firstName, String lastName, Integer age, String email, Role role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public User(){}

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null || o.getClass() != this.getClass())
            return false;

        User user = (User) o;

        return this.getId().equals(user.getId());

    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
}
