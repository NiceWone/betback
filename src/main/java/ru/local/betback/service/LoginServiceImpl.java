package ru.local.betback.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.local.betback.model.Token;
import ru.local.betback.model.User;
import ru.local.betback.repository.TokenRepository;
import ru.local.betback.repository.UserRepository;
import ru.local.betback.transfer.LoginDTO;
import ru.local.betback.transfer.TokenDTO;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final TokenRepository tokenRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(TokenRepository tokenRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findOneByLogin(loginDTO.getLogin());
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(loginDTO.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(15, true, true))
                        .build();

                tokenRepository.save(token);
                return TokenDTO.from(token);
            }
        }
        throw new IllegalArgumentException("user not found");
    }
}
