package ru.local.betback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Group;
import ru.local.betback.domain.Match;
import ru.local.betback.service.GroupRepository;

import java.util.Optional;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    private GroupRepository groupRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Group> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Group> getGroup(@PathVariable("id") String id) {
        return groupRepository.findById(Long.valueOf(id));
    }

//    @GetMapping
//    @CrossOrigin(origins = "http://localhost:4200")
//    public Iterable<Group> getGroups() {
//        return groupRepository.findAll();
//    }
}
