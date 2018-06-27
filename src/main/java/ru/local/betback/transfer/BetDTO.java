package ru.local.betback.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.local.betback.model.BetType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BetDTO {

    private BetType betType;
    private Long matchId;
    private Long userId;
    private Double bet;
}
