package com.example.boardproject.domain.user;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "users")
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;


    static User of(String email,String name, String password) {
        return new User(email, name,password);
    }

    private User(String email, String name, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    protected User() {

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


}
