package ru.local.betback.repository;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.model.Token;

import java.util.Optional;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);
}
