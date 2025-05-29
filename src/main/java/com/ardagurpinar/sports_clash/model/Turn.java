package com.ardagurpinar.sports_clash.model;

import com.ardagurpinar.sports_clash.model.enums.TurnStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "turns")
@Data
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY) // many turns can be in the same game
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY) // many turns can belong to the same player
    @JoinColumn(name = "user_id", nullable = false)
    private GameUser gameUser;

    @Column(nullable = false)
    private int turnNumber;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TurnStatus status = TurnStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY) // many turns can have the same player
    @JoinColumn(name = "chosen_player_name_id")
    private Player chosenPlayerName;




}
