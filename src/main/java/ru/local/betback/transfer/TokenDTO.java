package ru.local.betback.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.local.betback.model.Token;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
    private String value;

    public static TokenDTO from(Token token) {
        return new TokenDTO(token.getValue());
    }
}
