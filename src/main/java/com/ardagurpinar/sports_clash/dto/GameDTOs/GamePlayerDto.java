package com.ardagurpinar.sports_clash.dto.GameDTOs;

import lombok.Data;

import java.util.UUID;

@Data
public class GamePlayerDto {
    private UUID id;
    private UUID userId;
    private String role;
    private int joinOrder;
    private boolean isActive;
    private int pointsEarned;
}
