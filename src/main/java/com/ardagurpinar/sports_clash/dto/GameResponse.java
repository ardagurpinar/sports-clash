package com.ardagurpinar.sports_clash.dto;

import lombok.Data;

import java.util.List;

@Data
public class GameResponse {
    private List<GameDto> content;
}
