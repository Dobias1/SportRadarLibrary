package com.dobias1;

import java.util.Objects;

public class Match {
    private final String homeTeamName;
    private int homeTeamScore;
    private final String awayTeamName;
    private int awayTeamScore;

    /**
     * Creating match with initial score 0 - 0.
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

    public void setHomeTeamScore(int homeTeamScore) {
        if (homeTeamScore < 0) {
            throw new IllegalArgumentException("Negative homeTeamScore is not permitted");
        }
        this.homeTeamScore = homeTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        if (awayTeamScore < 0) {
            throw new IllegalArgumentException("Negative awayTeamScore is not permitted");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Match match = (Match) o;
        return getHomeTeamName().equals(match.getHomeTeamName()) &&
                getAwayTeamName().equals(match.getAwayTeamName()) &&
                getHomeTeamScore() == match.getHomeTeamScore() &&
                getAwayTeamScore() == match.getAwayTeamScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHomeTeamName(), getAwayTeamName(), getHomeTeamScore(), getAwayTeamScore());
    }

    @Override
    public String toString() {
        return homeTeamName + " " + homeTeamScore + " - " + awayTeamName + " " + awayTeamScore;
    }

}