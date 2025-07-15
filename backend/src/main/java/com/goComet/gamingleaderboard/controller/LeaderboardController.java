package com.goComet.gamingleaderboard.controller;

import com.goComet.gamingleaderboard.dto.ScoreSubmissionRequest;
import com.goComet.gamingleaderboard.entity.Leaderboard;
import com.goComet.gamingleaderboard.entity.User;
import com.goComet.gamingleaderboard.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "leaderboard")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitScore(@RequestBody ScoreSubmissionRequest request){
        leaderboardService.submitScore(request.getUserId(), request.getScore());
        return ResponseEntity.ok("Score submitted successfully");
    }

    @GetMapping("/top")
    public ResponseEntity<List<Leaderboard>> getTopPlayers(){
        return ResponseEntity.ok(leaderboardService.getTopPlayers());
    }

}
