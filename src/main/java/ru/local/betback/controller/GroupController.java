package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Group;
import ru.local.betback.domain.Match;
import ru.local.betback.service.GroupRepository;
import ru.local.betback.service.MatchRepository;

import java.util.Optional;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    private final GroupRepository groupRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Group> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Group> getGroup(@PathVariable("id") String id) {
        return groupRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateGroup(@RequestBody Group group, @PathVariable("id") String id) {
        groupRepository.save(group);
    }

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
