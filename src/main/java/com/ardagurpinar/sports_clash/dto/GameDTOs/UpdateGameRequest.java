package com.ardagurpinar.sports_clash.dto.GameDTOs;

import com.ardagurpinar.sports_clash.dto.TurnDTOs.TurnDto;
import com.ardagurpinar.sports_clash.model.enums.GameStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UpdateGameRequest {
    private GameStatus status;
    private Long winnerId;
    private Set<TurnDto> moves;
    private LocalDateTime updatedAt;
    private LocalDateTime endedAt;
}
