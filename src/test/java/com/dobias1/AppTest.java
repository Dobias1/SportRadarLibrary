package com.dobias1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AppTest {

    private final String homeTeamName;
    private final String awayTeamName;
    private final int homeTeamScore;
    private final int awayTeamScore;
    FootballWorldCupScoreBoard board;

    public AppTest(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    @Parameterized.Parameters(name = "{index}: HOME[{0}] - AWAY[{1}]: {2} - {3}")
    public static Collection<?> scores() {
        return Arrays.asList(new Object[][]{
                {"Mexico", "Canada", 0, 5},
                {"Spain", "Brazil", 10, 2},
                {"Germany", "France", 2, 2},
                {"Uruguay", "Italy", 6, 6},
                {"Argentina", "Australia", 3, 1}
        });
    }

    @Before
    public void setUp() {
        board = FootballWorldCupScoreBoardFactory.createFootballWorldCupScoreBoard();
    }

    @Test()
    public void checkStartMatchTest() {
        System.out.printf("Home '%s' Away '%s' Final scores %d %d %n", homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);
        assertTrue("Adding of match failed", board.startMatch(new Match(homeTeamName, homeTeamScore, awayTeamName, awayTeamScore)));
        assertEquals(board.getMatch(0).getHomeTeamName(), homeTeamName);
        assertEquals(board.getMatch(0).getAwayTeamName(), awayTeamName);
        assertEquals(board.getMatch(0).getHomeTeamScore(), homeTeamScore);
        assertEquals(board.getMatch(0).getAwayTeamScore(), awayTeamScore);
    }

}