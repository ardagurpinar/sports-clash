package com.ardagurpinar.sports_clash.model;

import com.ardagurpinar.sports_clash.model.enums.PlayerRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "game_users", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "game_id"}))
@Data
public class GameUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private PlayerRole role;

    @Column(name = "join_order", nullable = false)
    private int joinOrder;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "points_earned", nullable = false)
    private int pointsEarned = 0;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
