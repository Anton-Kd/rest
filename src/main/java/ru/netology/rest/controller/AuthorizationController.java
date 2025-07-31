package ru.netology.rest.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.rest.authorities.Authorities;
import ru.netology.rest.service.AuthorizationService;
import ru.netology.rest.user.UserInput;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid UserInput user) {
        return service.getAuthorities(user);
    }
}
