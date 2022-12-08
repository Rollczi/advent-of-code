package dev.rollczi.adventofcode2022.day02.rockpaperscissors;

import java.util.Map;

public class RockPaperScissorsResult {

    private static final int ADDITIONAL_WIN_POINTS = 6;
    private static final int ADDITIONAL_DRAW_POINTS = 3;

    private static final Map<RockPaperScissors, RockPaperScissors> DESTROYING_ANOTHER = Map.of(
            RockPaperScissors.ROCK, RockPaperScissors.SCISSORS,
            RockPaperScissors.PAPER, RockPaperScissors.ROCK,
            RockPaperScissors.SCISSORS, RockPaperScissors.PAPER
    );

    private final RockPaperScissors playerChoice;
    private final RockPaperScissors enemyChoice;

    private RockPaperScissorsResult(RockPaperScissors playerChoice, RockPaperScissors enemyChoice) {
        this.playerChoice = playerChoice;
        this.enemyChoice = enemyChoice;
    }

    public GameResult getResult() {
        if (playerChoice == enemyChoice) {
            return GameResult.DRAW;
        }

        RockPaperScissors destroying = DESTROYING_ANOTHER.get(playerChoice);

        if (destroying == enemyChoice) {
            return GameResult.WIN;
        }

        return GameResult.LOSE;
    }

    public int getPlayerPoints() {
        GameResult result = this.getResult();
        int points = playerChoice.getPoints();

        if (result == GameResult.DRAW) {
            points += ADDITIONAL_DRAW_POINTS;
        }

        if (result == GameResult.WIN) {
            points += ADDITIONAL_WIN_POINTS;
        }

        return points;
    }

    public int getEnemyPoints() {
        return enemyChoice.getPoints();
    }

    public static RockPaperScissorsResult of(RockPaperScissors playerChoice, RockPaperScissors enemyChoice) {
        return new RockPaperScissorsResult(playerChoice, enemyChoice);
    }

}
