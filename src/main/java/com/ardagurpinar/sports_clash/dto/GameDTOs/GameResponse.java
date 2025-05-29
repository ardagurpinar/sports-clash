package com.ardagurpinar.sports_clash.dto.GameDTOs;

import lombok.Data;

import java.util.List;

@Data
public class GameResponse {
    private List<GameDto> content;
}
