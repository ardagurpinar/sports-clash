package com.ardagurpinar.sports_clash.model;

import com.ardagurpinar.sports_clash.model.enums.SportsType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
@Data
public class Player {

    public Player(String fullName, SportsType sports, String nationality) {
        this.sports = sports;
        this.nationality = nationality;
        this.fullName = fullName;
        this.firstLetter = fullName.charAt(0);
        this.lastLetter = fullName.charAt(fullName.length() - 1);
    }

    public Player() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "first_letter", nullable = false)
    private char firstLetter;

    @Column(name = "last_letter", nullable = false)
    private char lastLetter;

    @Column(nullable = false)
    private SportsType sports;

    @Column(nullable = false)
    private String nationality;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}