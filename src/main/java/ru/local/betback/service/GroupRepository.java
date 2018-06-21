package ru.local.betback.service;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Group;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAllByOrderByIdAsc();
}
