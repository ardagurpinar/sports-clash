package com.ardagurpinar.sports_clash.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "players")
@Data
public class Player {

    public Player(String firstName, String lastName, SportsType sports, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sports = sports;
        this.nationality = nationality;
        this.fullName = firstName + " " + lastName;
        this.firstLetter = firstName.charAt(0);
        this.lastLetter = !lastName.isEmpty() ? lastName.charAt(lastName.length() - 1) : firstName.charAt(firstName.length() - 1);
    }

    public Player() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

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