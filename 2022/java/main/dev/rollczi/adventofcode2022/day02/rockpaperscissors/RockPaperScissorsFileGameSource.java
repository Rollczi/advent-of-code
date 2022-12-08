package dev.rollczi.adventofcode2022.day02.rockpaperscissors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissorsFileGameSource implements RockPaperScissorsEnemyInput, RockPaperScissorsPlayerInput {

    private final List<Result> results;

    private RockPaperScissorsFileGameSource(List<Result> results) {
        this.results = Collections.unmodifiableList(results);
    }

    @Override
    public Iterator<RockPaperScissors> enemyChoices() {
        return results.stream()
                .map(Result::enemyChoice)
                .iterator();
    }

    @Override
    public Iterator<RockPaperScissors> playerChoices() {
        return results.stream()
                .map(Result::playerChoice)
                .iterator();
    }

    public static RockPaperScissorsFileGameSource fromList(List<String> lines, LineParser lineParser) {
        List<Result> results = new ArrayList<>();

        for (String line : lines) {
            Result result = lineParser.parse(line);

            results.add(result);
        }

        return new RockPaperScissorsFileGameSource(results);
    }

    public static RockPaperScissorsFileGameSource ofFile(File file, LineParser lineParser) {
        try (Scanner reader = new Scanner(file)) {
            List<String> lines = new ArrayList<>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                lines.add(line);
            }

            return fromList(lines, lineParser);
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public interface LineParser {

        RockPaperScissorsFileGameSource.Result parse(String line);

    }

    record Result(RockPaperScissors playerChoice, RockPaperScissors enemyChoice) {
    }

}
