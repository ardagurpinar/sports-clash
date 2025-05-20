package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.GameDto;
import com.ardagurpinar.sports_clash.dto.GameResponse;
import com.ardagurpinar.sports_clash.exception.ResourceNotFoundException;
import com.ardagurpinar.sports_clash.model.Game;
import com.ardagurpinar.sports_clash.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.core.RepositoryCreationException;

import java.util.List;

public class GameServiceImplementation implements GameService{

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    public GameServiceImplementation(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GameResponse getAllGames() {
        List<Game> games = gameRepository.findAll();
        List<GameDto> gamesDto = games.stream()
                .map(game -> modelMapper.map(game, GameDto.class))
                .toList();
        GameResponse gameResponse = new GameResponse();
        gameResponse.setContent(gamesDto);
        return gameResponse;
    }

    @Override
    public GameResponse getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));
        GameDto gameDto = modelMapper.map(game, GameDto.class);
        GameResponse gameResponse = new GameResponse();
        gameResponse.setContent(List.of(gameDto));
        return gameResponse;
    }

    @Override
    public GameDto createGame(GameDto gameDto) {
        Game game = modelMapper.map(gameDto, Game.class);
        try {
            gameRepository.save(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RepositoryCreationException(e.getMessage(), e.getClass());
        }

        return modelMapper.map(game, GameDto.class);
    }

    @Override
    public GameDto updateGame(GameDto gameDto) {
        Game updatedGame = modelMapper.map(gameDto, Game.class);
        Game gameToBeUpdated = gameRepository.findById(updatedGame.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", updatedGame.getId()));
        gameToBeUpdated.setGamePlayers(updatedGame.getGamePlayers());
        gameToBeUpdated.setMoves(updatedGame.getMoves());
        gameRepository.save(gameToBeUpdated);
        return modelMapper.map(gameToBeUpdated, GameDto.class);
    }
}
