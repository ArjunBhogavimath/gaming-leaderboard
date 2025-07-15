package com.goComet.gamingleaderboard.service;

import com.goComet.gamingleaderboard.entity.GameSession;
import com.goComet.gamingleaderboard.entity.Leaderboard;
import com.goComet.gamingleaderboard.entity.User;
import com.goComet.gamingleaderboard.repository.GameSessionRepository;
import com.goComet.gamingleaderboard.repository.LeaderboardRepository;
import com.goComet.gamingleaderboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LeaderboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameSessionRepository gameSessionRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public void submitScore(Long userId, int score){

        //get the user object
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        //create game session
        GameSession gameSession = new GameSession();
        gameSession.setUser(user);
        gameSession.setScore(score);
        gameSession.setTimestamp(LocalDateTime.now());

        gameSessionRepository.save(gameSession);

        Double avgScore = gameSessionRepository.getAverageScoreByUserId(userId);
        int totalScore = avgScore != null ? avgScore.intValue() : score;

        Leaderboard leaderboard = leaderboardRepository.findByUserId(userId)
                .orElse(new Leaderboard());

        leaderboard.setUser(user);
        leaderboard.setTotalScore(totalScore);

        leaderboardRepository.save(leaderboard);
    }
}
