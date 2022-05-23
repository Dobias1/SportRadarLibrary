package com.dobias1;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AppTest {

    private final String homeTeamName;
    private final String awayTeamName;
    private final int homeTeamScore;
    private final int awayTeamScore;
    private final Match currentMatch;
    /**
     * Should set up new score of 10.
     */
    private static final int NEW_SCORE = 10;
    /**
     * Should raise error, while trying to set this score of -10.
     */
    private static final int NEW_NEGATIVE_SCORE = -10;
    FootballWorldCupScoreBoard board;

    public AppTest(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;

        this.currentMatch = new Match(homeTeamName, awayTeamName);
        this.currentMatch.setHomeTeamScore(homeTeamScore);
        this.currentMatch.setAwayTeamScore(awayTeamScore);
    }

    @Parameterized.Parameters(name = "{index}: HOME[{0}] - AWAY[{1}]: {2} - {3}")
    public static Collection<?> scores() {
        return Arrays.asList(new Object[][]{
                {"Slovakia", "Czech", 0, 0},
                {"Mexico", "Canada", 0, 5},
                {"Spain", "Brazil", 10, 2},
                {"Germany", "France", 2, 2},
                {"Uruguay", "Italy", 6, 6},
                {"Argentina", "Australia", 3, 1}
        });
    }

    @Before
    public void setUp() {
        System.out.println(StringUtils.repeat("=", 50));
        board = FootballWorldCupScoreBoardFactory.createFootballWorldCupScoreBoard();
        System.out.printf("Start match -> Home '%s' Away '%s' Final scores %d %d %n",
                homeTeamName,
                awayTeamName,
                homeTeamScore,
                awayTeamScore);
        assertTrue("Adding of match failed", board.startMatch(currentMatch));
    }

    @After
    public void tearDown() {
        System.out.println(StringUtils.repeat("=", 50));
    }

    private void evalBoard() {
        evalBoard(null);
    }

    private void evalBoard(Integer newScore) {
        assertEquals(board.getMatch(0).getHomeTeamName(), homeTeamName);
        assertEquals(board.getMatch(0).getAwayTeamName(), awayTeamName);
        assertEquals(board.getMatch(0).getHomeTeamScore(), newScore == null ? homeTeamScore : newScore);
        assertEquals(board.getMatch(0).getAwayTeamScore(), newScore == null ? awayTeamScore : newScore);
    }

    @Test
    public void startMatchTest() {
        evalBoard();
    }

    @Test
    public void updateScoreNormalTest() {
        System.out.printf("Changing score to %d %d %n", NEW_SCORE, NEW_SCORE);
        assertTrue(board.updateScore(0, NEW_SCORE, NEW_SCORE));
        evalBoard(NEW_SCORE);
    }

    @Test()
    public void updateScoreNegativeNumbers1Test() {
        System.out.printf("Changing score to %d %d %n", NEW_NEGATIVE_SCORE, NEW_SCORE);
        try {
            board.updateScore(0, NEW_NEGATIVE_SCORE, NEW_SCORE);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test()
    public void updateScoreNegativeNumbers2Test() {
        System.out.printf("Changing score to %d %d %n", NEW_SCORE, NEW_NEGATIVE_SCORE);
        try {
            board.updateScore(0, NEW_SCORE, NEW_NEGATIVE_SCORE);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test()
    public void updateScoreNegativeNumbers3Test() {
        System.out.printf("Changing score to %d %d %n", NEW_NEGATIVE_SCORE, NEW_NEGATIVE_SCORE);
        try {
            board.updateScore(0, NEW_NEGATIVE_SCORE, NEW_NEGATIVE_SCORE);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void finishMatchTest() {
        System.out.printf("Finishing match %s : %s %n", currentMatch.getHomeTeamName(), currentMatch.getAwayTeamName());
        System.out.printf("Final score %d %d %n", currentMatch.getHomeTeamScore(), currentMatch.getAwayTeamScore());
        assertTrue("Match was not removed from the board", board.finishMatch(currentMatch));
        assertTrue("Board after removing last match should be empty", board.isBoardEmpty());
    }

    /**
     * Test adds 1 match to already existing one and then tries to print the summary.
     */
    @Test
    public void summaryTest() {
        // prepare random matches
        Match firstMatch = new Match("TeamA", "TeamB");
        board.startMatch(firstMatch);
        board.updateScore(board.sizeOfBoard() - 1, 3, 4);
        Match secondMatch = new Match("TeamC", "TeamD");
        board.startMatch(secondMatch);
        board.updateScore(board.sizeOfBoard() - 1, 5, 5);

        // print out summary
        System.out.println("Printing out summary of the board:");
        String actual = board.getSummary();
        System.out.println(actual);

        // test if summary is ok
        StringBuilder sb = new StringBuilder();
        Map<Integer, Match> sortedMatches = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < board.sizeOfBoard(); i++) {
            Match eachMatch = board.getMatch(i);
            int sumOfScores = eachMatch.getHomeTeamScore() + eachMatch.getAwayTeamScore();
            sortedMatches.put(sumOfScores, eachMatch);
        }
        int i = 1;
        for (Match eachMatch : sortedMatches.values()) {
            sb.append(i++).append(". ").append(eachMatch).append("\n");
        }
        String expected = sb.toString();
        assertEquals("Summary doesn't match", expected, actual);
    }
}