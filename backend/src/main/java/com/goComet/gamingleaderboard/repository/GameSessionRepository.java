package com.goComet.gamingleaderboard.repository;

import com.goComet.gamingleaderboard.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}
