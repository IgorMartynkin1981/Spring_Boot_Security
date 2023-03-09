package ru.martynkin.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.martynkin.security.entity.User;
import ru.martynkin.security.services.UserService;

import java.security.Principal;

@RestController
public class MainUserController {

    private UserService userService;

    @Autowired
    public MainUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/admin")
    public String adminPage(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "adminPage, user: " + principal.getName() + "\n"
                + ", email: " + user.getEmail() + "\n"
                + ", password: " + user.getPassword();
    }

    @GetMapping("/pageAdminRole")
    public String pageAdminRole(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "pageAdminRole, user: " + principal.getName() + ", email: " + user.getEmail();
    }
}
