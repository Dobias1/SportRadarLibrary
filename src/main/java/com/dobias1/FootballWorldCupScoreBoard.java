package com.dobias1;

public interface FootballWorldCupScoreBoard {
    boolean startMatch(Match match);

    boolean finishMatch(Match match);

    boolean updateScore(Match match, int newHomeTeamScore, int newAwayTeamScore);

    String getSummary();

    Match getMatch(int index);
}