package com.goComet.gamingleaderboard.repository;

import com.goComet.gamingleaderboard.entity.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    Optional<Leaderboard> findByUserId(Long userId);


    @Query(value = """
    SELECT r.rank FROM (
      SELECT user_id, RANK() OVER (ORDER BY total_score DESC) AS rank
      FROM leaderboard
    ) r
    WHERE r.user_id = :userId
    """, nativeQuery = true)
    Integer getRankByUserId(@Param("userId") Long userId);
}
