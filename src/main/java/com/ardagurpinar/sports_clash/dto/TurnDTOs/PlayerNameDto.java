package com.ardagurpinar.sports_clash.dto.TurnDTOs;

import lombok.Data;

import java.util.UUID;

@Data
public class PlayerNameDto {
    private UUID id;
    private String fullName;
    private char firstLetter;
    private char lastLetter;
}
