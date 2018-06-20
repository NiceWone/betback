package ru.local.betback.service;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
}
