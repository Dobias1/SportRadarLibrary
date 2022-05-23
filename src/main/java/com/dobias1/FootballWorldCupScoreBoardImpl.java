package com.dobias1;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FootballWorldCupScoreBoardImpl implements FootballWorldCupScoreBoard {

    private final List<Match> matches = new ArrayList<>();

    @Override
    public boolean startMatch(Match match) {
        return matches.add(match);
    }

    @Override
    public boolean finishMatch(Match match) {
        return matches.remove(match);
    }

    @Override
    public boolean updateScore(int index, int newHomeTeamScore, int newAwayTeamScore) {
        if (newHomeTeamScore < 0 || newAwayTeamScore < 0) {
            throw new IllegalArgumentException("Negative score is not permitted");
        }
        Match editMatch = matches.remove(index);
        editMatch.setHomeTeamScore(newHomeTeamScore);
        editMatch.setAwayTeamScore(newAwayTeamScore);
        return matches.add(editMatch);
    }

    @Override
    public String getSummary() {
        return this.toString();
    }

    public Match getMatch(int index) {
        return ArrayUtils.get(matches.toArray(new Match[0]), index);
    }

    @Override
    public boolean isBoardEmpty() {
        return matches.isEmpty();
    }

    @Override
    public int sizeOfBoard() {
        return matches.size();
    }

    /**
     * We want to print matches in order of sum of the scores so-called interesting matches. This means the matches
     * with the highest scores will be first and least scores at last place.
     *
     * @return summary of all matches.
     */
    @Override
    public String toString() {
        List<Match> sortedMatches = matches
                .stream()
                .sorted(Comparator
                        .comparingInt(
                                eachMatch ->
                                        ((Match) eachMatch).getHomeTeamScore() + ((Match) eachMatch).getAwayTeamScore())
                        .reversed())
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedMatches.size(); i++) {
            sb.append(i + 1).append(". ").append(sortedMatches.get(i)).append("\n");
        }
        return sb.toString();
    }
}
