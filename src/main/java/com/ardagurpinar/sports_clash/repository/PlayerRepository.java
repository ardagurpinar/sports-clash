package com.ardagurpinar.sports_clash.repository;

import com.ardagurpinar.sports_clash.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
