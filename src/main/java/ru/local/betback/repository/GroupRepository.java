package ru.local.betback.repository;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.model.Group;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAllByOrderByIdAsc();
}
