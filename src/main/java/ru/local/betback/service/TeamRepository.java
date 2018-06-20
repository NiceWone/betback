package ru.local.betback.service;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
