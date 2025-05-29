package com.ardagurpinar.sports_clash.dto.TurnDTOs;

import lombok.Data;

import java.util.UUID;

@Data
public class SubmitTurnRequest {
    private UUID gameId;
    private UUID playerId;
    private int turnNumber;
    private String chosenName;
}
