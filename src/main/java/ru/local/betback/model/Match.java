package ru.local.betback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Team team1;
    @OneToOne
    private Team team2;
    private Integer scoreTeam1;
    private Integer scoreTeam2;
    private Date date;
    @Column(columnDefinition = "true")
    private boolean isGroupStage;
}
