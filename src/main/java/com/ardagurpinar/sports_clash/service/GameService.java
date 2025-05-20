package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.GameDto;
import com.ardagurpinar.sports_clash.dto.GameResponse;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    GameResponse getAllGames();
    GameResponse getGameById(Long id);
    GameDto createGame(GameDto gameDto);
    GameDto updateGame(GameDto gameDto);
}
