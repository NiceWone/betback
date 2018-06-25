package ru.local.betback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.local.betback.model.Role;
import ru.local.betback.model.State;
import ru.local.betback.model.User;
import ru.local.betback.repository.UserRepository;
import ru.local.betback.services.LoginService;
import ru.local.betback.transfer.LoginDTO;
import ru.local.betback.transfer.TokenDTO;
import ru.local.betback.transfer.UserDTO;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(LoginService loginService,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(loginService.login(loginDTO));
    }

    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody UserDTO userDTO) {
        String hashPassword = passwordEncoder.encode(userDTO.getPassword());

        User user = User.builder()
                .login(userDTO.getLogin())
                .hashPassword(hashPassword)
                .email(userDTO.getEmail())
                .state(State.ACTIVE)
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
