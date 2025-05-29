package com.ardagurpinar.sports_clash.dto.GameDTOs;

import com.ardagurpinar.sports_clash.model.enums.GameStatus;
import com.ardagurpinar.sports_clash.model.enums.SportsType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class GameDto {
    private UUID id;
    private String gameCode;
    private GameStatus status;
    private SportsType sports;
    private int timePerTurn;
    private String startingPlayerName;
    private UUID winnerId;
    private List<GamePlayerDto> gamePlayers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime endedAt;
}
