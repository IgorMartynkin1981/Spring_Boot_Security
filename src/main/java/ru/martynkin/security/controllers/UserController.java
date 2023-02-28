package ru.martynkin.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.martynkin.security.responseFormats.MessageResponse;

/**
 * @CrossOrigin указывает совместное использование ресурсов из разных источников и в нём указано,
 * что любой входящий запрос из любого источника не должен блокироваться.
 */

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/test")
public class UserController {

    @GetMapping("/all")
    public MessageResponse allAccess() {
        return new MessageResponse("Server is up.....");
    }

    @GetMapping("/greeting")
    @PreAuthorize("isAuthenticated()")
    public MessageResponse userAccess() {

        return new MessageResponse
                ("Congratulations! You are an authenticated user.");
    }
}


