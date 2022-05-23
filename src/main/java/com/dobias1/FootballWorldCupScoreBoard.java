package com.dobias1;

public interface FootballWorldCupScoreBoard {
    boolean startMatch(Match match);

    boolean finishMatch(Match match);

    boolean updateScore(int index, int newHomeTeamScore, int newAwayTeamScore);

    String getSummary();

    Match getMatch(int index);

    boolean isBoardEmpty();

    int sizeOfBoard();
}