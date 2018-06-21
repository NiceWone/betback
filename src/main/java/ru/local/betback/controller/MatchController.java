package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Match;
import ru.local.betback.service.MatchRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping
    public List<Match> getMatches() {
        return matchRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatch(@PathVariable("id") String id) {
        return matchRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateMatch(@RequestBody Match match, @PathVariable("id") String id) {
        matchRepository.save(match);
    }

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
}
