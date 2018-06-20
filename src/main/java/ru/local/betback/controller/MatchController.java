package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Match;
import ru.local.betback.service.MatchRepository;

import java.util.Optional;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController {

    private MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public Iterable<Match> getMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatch(@PathVariable("id") String id) {
        return matchRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateMatch(@RequestBody Match match, @PathVariable("id") String id) {
        matchRepository.save(match);
    }
}
