package com.ardagurpinar.sports_clash.repository;

import com.ardagurpinar.sports_clash.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
