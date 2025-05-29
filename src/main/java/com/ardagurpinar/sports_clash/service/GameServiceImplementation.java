package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.GameDTOs.*;
import com.ardagurpinar.sports_clash.exception.ResourceNotFoundException;
import com.ardagurpinar.sports_clash.model.Game;
import com.ardagurpinar.sports_clash.model.enums.GameStatus;
import com.ardagurpinar.sports_clash.repository.GameRepository;
import com.ardagurpinar.sports_clash.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GameServiceImplementation implements GameService{

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public GameServiceImplementation(GameRepository gameRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
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
    public GameResponse getGameById(UUID id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));
        GameDto gameDto = modelMapper.map(game, GameDto.class);
        GameResponse gameResponse = new GameResponse();
        gameResponse.setContent(List.of(gameDto));
        return gameResponse;
    }

    @Override
    public GameResponse getGameByGameCode(String gameCode) {
        Game game = gameRepository.findByGameCode(gameCode)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "gameCode", gameCode));
        GameDto gameDto = modelMapper.map(game, GameDto.class);
        GameResponse gameResponse = new GameResponse();
        gameResponse.setContent(List.of(gameDto));
        return gameResponse;
    }

    @Override
    public GameDto createGame(CreateGameRequest req) {
        Game game = modelMapper.map(req, Game.class);
        try {
            gameRepository.save(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RepositoryCreationException(e.getMessage(), e.getClass());
        }

        return modelMapper.map(game, GameDto.class);
    }

    @Override
    public GameDto updateGame(UpdateGameRequest gameDto, UUID id) {
//        Game updatedGame = modelMapper.map(gameDto, Game.class);
//        System.out.println("updatedGame: " + updatedGame);
        Game gameToBeUpdated = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));

        gameToBeUpdated.setStatus(gameDto.getStatus());

//        Set<MoveDto> moveDtos = gameDto.getMoves();
//
//        for (MoveDto moveDto : moveDtos) {
//            Move move = new Move();
//            User user = userRepository.findById(moveDto.getUserId()).orElseThrow();
//            move.setGame(gameToBeUpdated);
//            move.setUser(user);
//            move.setPlayerName(moveDto.getPlayerName());
//            move.setIsValid(moveDto.getIsValid());
//            move.setTurnNumber(moveDto.getTurnNumber());
//            gameToBeUpdated.getMoves().add(move);
//        }

        //gameToBeUpdated.setMoves(updatedGame.getMoves());

        if (gameDto.getStatus().equals(GameStatus.COMPLETED) || gameDto.getStatus().equals(GameStatus.CANCELLED)) {
            //gameToBeUpdated.setWinnerId(gameDto.getWinnerId());
            gameToBeUpdated.setUpdatedAt(LocalDateTime.now());
            gameToBeUpdated.setEndedAt(LocalDateTime.now());
        }
        gameRepository.save(gameToBeUpdated);
        return modelMapper.map(gameToBeUpdated, GameDto.class);
    }

    @Override
    public GameDto joinGame(UUID userId, JoinGameRequest req) {

        return null;
    }
}
