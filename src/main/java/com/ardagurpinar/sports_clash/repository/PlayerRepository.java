package com.ardagurpinar.sports_clash.repository;

import com.ardagurpinar.sports_clash.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Optional<Player> findByFullName(String fullName);
}
