package ru.martynkin.security.responseFormats;

//JwtReponse.java

import lombok.Getter;
import lombok.Setter;

/**
 * this file will return us the operated user object and the token associated
 * with it after successful login attempt.
 */
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;

    public JwtResponse(String accessToken, Long id, String username, String email) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
