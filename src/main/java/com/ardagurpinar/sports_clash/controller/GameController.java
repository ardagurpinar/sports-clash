package com.ardagurpinar.sports_clash.controller;

import com.ardagurpinar.sports_clash.dto.CreateGameRequest;
import com.ardagurpinar.sports_clash.dto.GameDto;
import com.ardagurpinar.sports_clash.dto.GameResponse;
import com.ardagurpinar.sports_clash.dto.UpdateGameRequest;
import com.ardagurpinar.sports_clash.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<GameResponse> getAllGames() {
        GameResponse gameResponse = gameService.getAllGames();
        return ResponseEntity.ok(gameResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> getGameById(@PathVariable Long id) {
        GameResponse gameResponse = gameService.getGameById(id);
        return ResponseEntity.ok(gameResponse);
    }

    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody CreateGameRequest gameDto) {
        GameDto newGame = gameService.createGame(gameDto);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GameDto> updateGame(@RequestBody UpdateGameRequest gameDto, @PathVariable Long id) {
        GameDto updatedGame = gameService.updateGame(gameDto, id);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }
}
