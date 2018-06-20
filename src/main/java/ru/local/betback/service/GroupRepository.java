package ru.local.betback.service;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
