package com.ardagurpinar.sports_clash.repository;

import com.ardagurpinar.sports_clash.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
    Optional<Game> findByGameCode(String gameCode);
}
