package ru.local.betback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BetType betType;
    @ManyToOne
    private Match match;
    @OneToOne
    private User user;
    private Double bet;
}
