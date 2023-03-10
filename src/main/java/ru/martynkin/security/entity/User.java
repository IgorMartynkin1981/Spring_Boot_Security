package ru.martynkin.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Simple domain object that represents application user.
 *
 * @author Igor Martynkin
 * @version 1.0
 */

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    @Column(length = 512, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<Role> roles;
}

