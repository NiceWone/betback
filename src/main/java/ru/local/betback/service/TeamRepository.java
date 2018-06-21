package ru.local.betback.service;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Team;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAllByOrderByIdAsc();
}
