package dev.rollczi.adventofcode2022.day02;

import dev.rollczi.adventofcode2022.day02.rockpaperscissors.AdventOfCodeLineParser;
import dev.rollczi.adventofcode2022.day02.rockpaperscissors.RockPaperScissorsFileGameSource;
import dev.rollczi.adventofcode2022.day02.rockpaperscissors.RockPaperScissorsResult;
import dev.rollczi.adventofcode2022.day02.rockpaperscissors.RockPaperScissorsService;

import java.io.File;
import java.util.List;

public class Day02 {

    public static void main(String[] args) {
        RockPaperScissorsFileGameSource source = RockPaperScissorsFileGameSource.ofFile(new File("2022/resources/day-02.txt"), new AdventOfCodeLineParser());
        RockPaperScissorsService service = new RockPaperScissorsService(source);

        List<RockPaperScissorsResult> results = service.play(source);

        int sum = results.stream().mapToInt(RockPaperScissorsResult::getPlayerPoints)
                .sum();

        System.out.println(sum);
    }

}
