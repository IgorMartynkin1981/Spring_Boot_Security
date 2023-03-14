package ru.martynkin.security.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.martynkin.security.dto.UserRegistration;
import ru.martynkin.security.services.AdministratorService;

@RestController
@RequestMapping(value = "/adminka/")
public class AdministratorController {

    private AdministratorService adminService;

    @Autowired
    public AdministratorController(AdministratorService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public String adminPage() {
        return "This's adminka";
    }

    @PostMapping("signup")
    public ResponseEntity<?> authUser(@Valid @RequestBody UserRegistration userRegistration) {

        return ResponseEntity.ok(adminService.createUser(userRegistration));
    }
}
