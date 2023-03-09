package ru.martynkin.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainUserController {

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/admin")
    public String adminPage(Principal principal) {
        return "adminPage, user: " + principal.getName();
    }

    @GetMapping("/pageAdminRole")
    public String pageAdminRole(Principal principal) {
        return "pageAdminRole, user: " + principal.getName();
    }
}
