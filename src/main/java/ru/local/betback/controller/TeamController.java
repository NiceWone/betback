package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Group;
import ru.local.betback.domain.Match;
import ru.local.betback.domain.Team;
import ru.local.betback.service.MatchRepository;
import ru.local.betback.service.TeamRepository;

import java.util.Optional;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    private final TeamRepository teamRepository;

    @GetMapping
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Team> getGroup(@PathVariable("id") String id) {
        return teamRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateMatch(@RequestBody Team team, @PathVariable("id") String id) {
        teamRepository.save(team);
    }

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
