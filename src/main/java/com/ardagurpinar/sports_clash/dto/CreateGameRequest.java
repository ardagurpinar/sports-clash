package com.ardagurpinar.sports_clash.dto;

import com.ardagurpinar.sports_clash.model.GameStatus;
import com.ardagurpinar.sports_clash.model.SportsType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateGameRequest {
    private GameStatus status;
    private SportsType sports;
    private int timePerTurn;
    private String startingPlayerName;
    private LocalDateTime createdAt;
}
