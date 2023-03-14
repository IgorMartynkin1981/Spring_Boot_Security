package ru.martynkin.security.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Simple domain object that represents application roles
 * Simple domain object that represents application user's role - ADMIN, USER, etc.
 *
 * @author Igor Martynkin
 * @version 1.0
 */

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
