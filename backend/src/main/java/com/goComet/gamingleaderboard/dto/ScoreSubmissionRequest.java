package com.goComet.gamingleaderboard.dto;

public class ScoreSubmissionRequest {

    private Long userId;
    private int score;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
