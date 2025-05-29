package com.ardagurpinar.sports_clash.dto.GameDTOs;

import com.ardagurpinar.sports_clash.model.enums.GameStatus;
import com.ardagurpinar.sports_clash.model.enums.SportsType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateGameRequest {
    private SportsType sports;
    private int timePerTurn;
    private int numberOfPlayers; // should be added to the Game entity
}
