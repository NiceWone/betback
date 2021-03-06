package ru.local.betback.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.local.betback.model.Token;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDTO {
    private String value;

    public static TokenDTO from(Token token) {
        return new TokenDTO(token.getValue());
    }
}
