package com.ardagurpinar.sports_clash.model;

import com.ardagurpinar.sports_clash.model.enums.GameStatus;
import com.ardagurpinar.sports_clash.model.enums.SportsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "games")
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "game_code", length = 6, nullable = false, unique = true)
    private String gameCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SportsType sports;

    @Column(name = "time_per_turn", nullable = false)
    private int timePerTurn;

    @Column(name = "starting_player_name", nullable = false)
    private String startingPlayerName;

    @Column(name = "winner_id")
    private UUID winnerId;

    @Column(name = "number_of_players", nullable = false)
    @Min(2)
    private int numberOfPlayers;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<GameUser> gameUsers = new ArrayList<>();

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Turn> turns = new ArrayList<>();
}
