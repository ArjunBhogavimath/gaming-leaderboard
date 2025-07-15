package com.goComet.gamingLeaderboard.repository;

import com.goComet.gamingLeaderboard.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepositpry extends JpaRepository<GameSession, Long> {
}
