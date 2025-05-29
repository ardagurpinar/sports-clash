package com.ardagurpinar.sports_clash.repository;

import com.ardagurpinar.sports_clash.model.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameUserRepository extends JpaRepository<GameUser, UUID> {

}
