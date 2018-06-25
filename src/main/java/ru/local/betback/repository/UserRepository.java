package ru.local.betback.repository;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByLogin(String login);

    List<User> findAll();
}
