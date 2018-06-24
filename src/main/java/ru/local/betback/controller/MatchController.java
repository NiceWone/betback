package ru.local.betback.controller;

import org.springframework.web.bind.annotation.*;
import ru.local.betback.domain.Match;
import ru.local.betback.service.MatchRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/matches")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping
    public List<Match> getMatches() {
        return matchRepository.findAllByOrderByIdAsc();
    }

    @GetMapping(params = {"group_id"})
    public List<Match> getMatches2(
            @RequestParam(value = "group_id") int id) {
        return matchRepository.getMatchesByGroupId(id);
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatch(@PathVariable("id") String id) {
        return matchRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public void updateMatch(@RequestBody Match match, @PathVariable("id") String id) {
        matchRepository.save(match);
    }

    @PostMapping
    public void saveMatch(@RequestBody Match match) {
        matchRepository.save(match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable("id") String id) {
        matchRepository.deleteById(Long.valueOf(id));
    }

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
}
