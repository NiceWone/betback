package ru.local.betback.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.local.betback.domain.Team;
import ru.local.betback.service.TeamRepository;

@RestController
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }
}
