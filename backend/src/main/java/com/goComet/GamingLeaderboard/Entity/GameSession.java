package com.goComet.GamingLeaderboard.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "game_session")
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Column( name = "user_id")
    private User user;

    private int score;

    @Column(name = "game_mode")
    private String gameMode = "solo";

    private LocalDateTime timestamp = LocalDateTime.now();

}
