package dev.rollczi.adventofcode2022;

import dev.rollczi.adventofcode2022.day02.rockpaperscissors.AdventOfCodeLineParser;
import dev.rollczi.adventofcode2022.day02.rockpaperscissors.RockPaperScissorsFileGameSource;
import dev.rollczi.adventofcode2022.day02.rockpaperscissors.RockPaperScissorsResult;
import dev.rollczi.adventofcode2022.day02.rockpaperscissors.RockPaperScissorsService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    // Rock - 1 point
    // Paper - 2 points
    // Scissors - 3 points

    // additional points for winning 6
    // additional points for draw 3

    // Rock vs Rock - 1+3
    // Rock vs Paper - 1
    // Rock vs Scissors - 1+6

    // Paper vs Rock - 2+6
    // Paper vs Paper - 2+3
    // Paper vs Scissors - 2

    // Scissors vs Rock - 3
    // Scissors vs Paper - 3+6
    // Scissors vs Scissors - 3+3

    // A X -> Rock
    // B Y -> Paper
    // C Z -> Scissors

    @Test
    void test() {
        List<String> in = List.of(
                "A Y", // rock vs paper - 1
                "B Z", // paper vs scissors - 2
                "C X", // scissors vs rock - 3
                "A X", // rock vs rock - 1+3 = 4
                "B Y", // paper vs paper - 2+3 = 5
                "C Z", // scissors vs scissors - 3+3 = 6
                "A Z", // rock vs scissors - 1+6 = 7
                "B X", // paper vs rock - 2+6 = 8
                "C Y"  // scissors vs paper - 3+6 = 9
        );

        assertInput(in, 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);
    }

    private void assertInput(List<String> input, int expected) {
        RockPaperScissorsFileGameSource source = RockPaperScissorsFileGameSource.fromList(input, new AdventOfCodeLineParser());
        RockPaperScissorsService service = new RockPaperScissorsService(source);

        List<RockPaperScissorsResult> results = service.play(source);

        int sum = results.stream().mapToInt(RockPaperScissorsResult::getPlayerPoints)
                .sum();

        assertEquals(expected, sum);
    }

}
