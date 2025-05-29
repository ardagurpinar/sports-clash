package com.ardagurpinar.sports_clash.config;

import com.ardagurpinar.sports_clash.model.Player;
import com.ardagurpinar.sports_clash.model.enums.SportsType;
import com.ardagurpinar.sports_clash.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    ModelMapper modelMapper() { return new ModelMapper(); }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner seedPlayerData(PlayerRepository playerRepository) {
        return args -> {
            if (playerRepository.count() == 0) {
                List<Player> seed = List.of(
                        new Player("Lionel Messi", SportsType.FOOTBALL, "Argentina"),
                        new Player("Cristiano Ronaldo", SportsType.FOOTBALL, "Portugal"),
                        new Player("Olcay Şahan", SportsType.FOOTBALL, "Turkish"),
                        new Player("Neymar", SportsType.FOOTBALL, "Brazil"),
                        new Player("Ronaldo Nazario", SportsType.FOOTBALL, "Brazil"),
                        new Player("Lebron James", SportsType.BASKETBALL, "USA"),
                        new Player("Kobe Bryant", SportsType.BASKETBALL, "USA"),
                        new Player("Michael Jordan", SportsType.BASKETBALL, "USA"),
                        new Player("Sergio Lull", SportsType.BASKETBALL, "Spain"),
                        new Player("Luka Doncic", SportsType.BASKETBALL, "Slovenia")
                        );

                playerRepository.saveAll(seed);
            }
        };
    }
}
