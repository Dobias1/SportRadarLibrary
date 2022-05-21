package com.dobias1;

public class FootballWorldCupScoreBoardFactory {
    private FootballWorldCupScoreBoardFactory() {
    }

    public static FootballWorldCupScoreBoard createFootballWorldCupScoreBoard() {
        return new FootballWorldCupScoreBoardImpl();
    }
}
