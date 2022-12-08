package dev.rollczi.adventofcode2022.day02.rockpaperscissors;

public enum RockPaperScissors {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int points;

    RockPaperScissors(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

}
