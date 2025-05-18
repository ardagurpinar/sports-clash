package com.ardagurpinar.sports_clash.repository;


import com.ardagurpinar.sports_clash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findTop100ByOrderByTotalPointsDesc();
}
