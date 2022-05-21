package com.dobias1;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class FootballWorldCupScoreBoardImpl implements FootballWorldCupScoreBoard {

    private final List<Match> maches = new ArrayList<>();

    @Override
    public boolean startMatch(Match match) {
        return maches.add(match);
    }

    @Override
    public boolean finishMatch(Match match) {
        return false;
    }

    @Override
    public boolean updateScore(Match match, int newHomeTeamScore, int newAwayTeamScore) {
        return false;
    }

    @Override
    public String getSummary() {
        return null;
    }

    public Match getMatch(int index) {
        return ArrayUtils.get(maches.toArray(new Match[0]), index);
    }
}
