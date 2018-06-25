package ru.local.betback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.local.betback.model.User;
import ru.local.betback.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") String id) {
        return userRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") String id) {
        if (user.getLogin().trim().equals(""))
            return;
        userRepository.save(user);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        if (user.getLogin().trim().equals(""))
            return;
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") String id) {
        userRepository.deleteById(Long.valueOf(id));
    }
}
