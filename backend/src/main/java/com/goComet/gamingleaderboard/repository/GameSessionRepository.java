package com.goComet.gamingleaderboard.repository;

import com.goComet.gamingleaderboard.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {

    @Query("SELECT AVG(gs.score) FROM GameSession gs WHERE gs.user.id = :userId")
    Double getAverageScoreByUserId(@Param("userId") Long userId);
}
