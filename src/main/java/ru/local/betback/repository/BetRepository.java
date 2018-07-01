package ru.local.betback.repository;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.model.Bet;

import java.util.List;

public interface BetRepository extends CrudRepository<Bet, Long> {

    List<Bet> findAll();
}