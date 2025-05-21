package com.ardagurpinar.sports_clash.dto;

import com.ardagurpinar.sports_clash.model.GameStatus;
import com.ardagurpinar.sports_clash.model.Move;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UpdateGameRequest {
    private GameStatus status;
    private Long winnerId;
    private Set<Move> moves;
    private LocalDateTime updatedAt;
    private LocalDateTime endedAt;
}
