package ru.martynkin.security.dto;

import lombok.Data;

@Data
public class UserInfo {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;
}
