package ru.local.betback.service;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Match;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> findAllByOrderByIdAsc();
}
