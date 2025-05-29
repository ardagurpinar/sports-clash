package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.GameDTOs.*;

import java.util.UUID;

public interface GameService {
    GameResponse getAllGames();
    GameResponse getGameById(UUID id);
    GameResponse getGameByGameCode(String gameCode);
    GameDto createGame(CreateGameRequest gameDto);
    GameDto updateGame(UpdateGameRequest gameDto, UUID id);
    GameDto joinGame(UUID userId, JoinGameRequest req);
}
