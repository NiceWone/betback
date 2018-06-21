package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Team;
import ru.local.betback.service.TeamRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    private final TeamRepository teamRepository;

    @GetMapping
    public List<Team> getTeams() {
        return teamRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeam(@PathVariable("id") String id) {
        return teamRepository.findById(Long.valueOf(id));
    }

    @GetMapping("freeTeams")
    public Optional<Team> getTeamFreeGroup(@PathVariable("id") String id) {
        return teamRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable("id") String id) {
        if (team.getName().trim().equals(""))
            return;
        teamRepository.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") String id) {
        teamRepository.deleteById(Long.valueOf(id));
    }

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
