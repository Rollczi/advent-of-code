package dev.rollczi.adventofcode2022.day02.rockpaperscissors;

import java.util.Map;

public class AdventOfCodeLineParser implements RockPaperScissorsFileGameSource.LineParser {

    private static final Map<Character, RockPaperScissors> MAP = Map.of(
            'A', RockPaperScissors.ROCK,
            'B', RockPaperScissors.PAPER,
            'C', RockPaperScissors.SCISSORS,
            'X', RockPaperScissors.ROCK,
            'Y', RockPaperScissors.PAPER,
            'Z', RockPaperScissors.SCISSORS
    );

    @Override
    public RockPaperScissorsFileGameSource.Result parse(String line) {
        if (line.length() < 3) {
            throw new IllegalArgumentException("Line must be at least 3 characters long");
        }

        RockPaperScissors enemyChoice = MAP.get(line.charAt(0));
        RockPaperScissors playerChoice = MAP.get(line.charAt(2));

        return new RockPaperScissorsFileGameSource.Result(playerChoice, enemyChoice);
    }

}
