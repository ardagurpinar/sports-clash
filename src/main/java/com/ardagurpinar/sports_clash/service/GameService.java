package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.CreateGameRequest;
import com.ardagurpinar.sports_clash.dto.GameDto;
import com.ardagurpinar.sports_clash.dto.GameResponse;
import com.ardagurpinar.sports_clash.dto.UpdateGameRequest;

public interface GameService {
    GameResponse getAllGames();
    GameResponse getGameById(Long id);
    GameDto createGame(CreateGameRequest gameDto);
    GameDto updateGame(UpdateGameRequest gameDto, Long id);
}
