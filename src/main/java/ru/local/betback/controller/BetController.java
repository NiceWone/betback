package ru.local.betback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.local.betback.model.Bet;
import ru.local.betback.repository.BetRepository;
import ru.local.betback.transfer.BetDTO;

@RestController
@RequestMapping("api/bets")
public class BetController {

    private final BetRepository betRepository;

    public BetController(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @GetMapping
    public BetDTO getBets() {
        final Bet bet = betRepository.findAll().stream().findFirst().get(); // TODO: add isPresent
        return BetDTO.builder()
                .bet(bet.getBet())
                .betType(bet.getBetType())
                .matchId(bet.getMatch().getId())
                .userId(bet.getUser().getId())
                .build();
    }

}
