package ru.local.betback.services;

import ru.local.betback.transfer.LoginDTO;
import ru.local.betback.transfer.TokenDTO;

public interface LoginService {
    TokenDTO login(LoginDTO loginDTO);
}
