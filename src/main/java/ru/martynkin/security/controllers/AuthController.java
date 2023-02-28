package ru.martynkin.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.martynkin.security.data.UserRepository;
import ru.martynkin.security.entity.User;
import ru.martynkin.security.requestFormat.LoginRequest;
import ru.martynkin.security.requestFormat.SignupRequest;
import ru.martynkin.security.responseFormats.JwtResponse;
import ru.martynkin.security.responseFormats.MessageResponse;
import ru.martynkin.security.security.jwt.JwtUtils;
import ru.martynkin.security.security.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateuser
            (@RequestBody LoginRequest loginRequest) {

        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken
                        (loginRequest.getUsername(),
                                loginRequest.getPassword()));

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl)
                authentication.getPrincipal();

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser
            (@RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest
                .getUsername())) {

            return ResponseEntity.badRequest()
                    .body(new MessageResponse
                            ("Error: username is already taken!"));
        }

        if (userRepository.existsByEmail
                (signUpRequest.getEmail())) {

            return ResponseEntity.badRequest()
                    .body(new MessageResponse
                            ("Error: Email is already in use!"));
        }

        // Create new user account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity
                .ok(new MessageResponse("user registered successfully!"));
    }
}
