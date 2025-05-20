package com.ardagurpinar.sports_clash.dto;

import com.ardagurpinar.sports_clash.model.GameStatus;
import com.ardagurpinar.sports_clash.model.SportsType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameDto {
    private GameStatus status;

    private SportsType sports;

    private int timePerTurn;

    private String startingPlayerName;

    private Long winnerId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime endedAt;
}
