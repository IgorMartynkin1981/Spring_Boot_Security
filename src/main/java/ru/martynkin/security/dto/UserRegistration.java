package ru.martynkin.security.dto;

import lombok.Data;
import ru.martynkin.security.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
public class UserRegistration {
    private Long id;

    @NotBlank(message = "Name may not be blank")
    private String username;

    @NotBlank(message = "Name may not be blank")
    @Size(min = 1, max = 16)
    private String password;

    private String firstName;

    private String lastName;

    @NotBlank(message = "Name may not be blank")
    @Email
    private String email;

    private Collection<Role> roles;
}
