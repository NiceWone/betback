package ru.local.betback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.local.betback.model.Role;
import ru.local.betback.model.State;
import ru.local.betback.model.User;
import ru.local.betback.repository.UserRepository;
import ru.local.betback.transfer.UserDTO;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
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

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
