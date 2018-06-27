package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.model.Team;
import ru.local.betback.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/teams")
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

    @PutMapping("/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable("id") String id) {
        if (team.getName().trim().equals(""))
            return;
        teamRepository.save(team);
    }

    @PostMapping
    public void saveTeam(@RequestBody Team team) {
        if (team.getName().trim().equals(""))
            return;
        teamRepository.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") String id) {
        teamRepository.deleteById(Long.valueOf(id));
    }

    @GetMapping("/freeTeams")
    public List<Team> getTeamFreeGroup() {
        return teamRepository.getTeamFreeGroup();
    }

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
