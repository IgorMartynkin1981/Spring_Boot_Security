package ru.martynkin.security.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "auser")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        super();
    }


}
