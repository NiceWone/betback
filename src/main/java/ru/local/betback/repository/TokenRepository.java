package ru.local.betback.repository;

import org.springframework.data.repository.CrudRepository;
import ru.local.betback.model.Token;

public interface TokenRepository extends CrudRepository<Token, Long> {
}
