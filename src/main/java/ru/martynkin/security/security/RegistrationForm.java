package ru.martynkin.security.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.martynkin.security.User;


@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String fullname;
  
  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(username, passwordEncoder.encode(password), fullname);
  }
  
}
