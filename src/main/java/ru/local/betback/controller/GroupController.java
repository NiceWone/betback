package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Group;
import ru.local.betback.service.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class GroupController {

    private final GroupRepository groupRepository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Group> getGroups() {
        return groupRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public Optional<Group> getGroup(@PathVariable("id") String id) {
        return groupRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateGroup(@RequestBody Group group, @PathVariable("id") String id) {
        groupRepository.save(group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") String id) {
        groupRepository.deleteById(Long.valueOf(id));
    }

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
