package com.dobias1;

public class Match {
    private final String homeTeamName;
    private final int homeTeamScore;
    private final String awayTeamName;
    private final int awayTeamScore;

    /**
     * This constructor is used, when we want to start with 0 values for scores.
     *
     * @param homeTeamName name of home team in match.
     * @param awayTeamName name of away team in match.
     */
    public Match(String homeTeamName, String awayTeamName) {
        this.homeTeamName = homeTeamName;
        this.homeTeamScore = 0;
        this.awayTeamName = awayTeamName;
        this.awayTeamScore = 0;
    }

    public Match(String homeTeamName, int homeTeamScore, String awayTeamName, int awayTeamScore) {
        this.homeTeamName = homeTeamName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamName = awayTeamName;
        this.awayTeamScore = awayTeamScore;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }
}