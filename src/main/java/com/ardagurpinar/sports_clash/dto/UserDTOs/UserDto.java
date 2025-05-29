package com.ardagurpinar.sports_clash.dto.UserDTOs;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String username;
    private int totalPoints;
    private int totalGamesPlayed;
    private int gamesWon;
    private LocalDateTime createdAt;
    private String token;

}
