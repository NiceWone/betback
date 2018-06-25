package ru.local.betback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String login;
    @NotNull
    private String hashPassword;
    private String email;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Token> tokens;
}
