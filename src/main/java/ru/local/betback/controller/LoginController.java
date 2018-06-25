package ru.local.betback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.local.betback.services.LoginService;
import ru.local.betback.transfer.LoginDTO;
import ru.local.betback.transfer.TokenDTO;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(loginService.login(loginDTO));
    }
}
