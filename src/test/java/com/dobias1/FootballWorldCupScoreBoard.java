package com.dobias1;

public interface FootballWorldCupScoreBoard {
    boolean startGame(Game game);

    boolean finishGame(Game game);

    boolean updateScore(Game game, int newHomeTeamScore, int newAwayTeamScore);

    String getSummary();
}