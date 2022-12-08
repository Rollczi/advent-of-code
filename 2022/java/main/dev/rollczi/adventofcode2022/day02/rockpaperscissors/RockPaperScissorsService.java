package dev.rollczi.adventofcode2022.day02.rockpaperscissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RockPaperScissorsService {

    private final RockPaperScissorsEnemyInput enemyInput;

    public RockPaperScissorsService(RockPaperScissorsEnemyInput enemyInput) {
        this.enemyInput = enemyInput;
    }

    public List<RockPaperScissorsResult> play(RockPaperScissorsPlayerInput playerInput) {
        Iterator<RockPaperScissors> playerChoices = playerInput.playerChoices();
        Iterator<RockPaperScissors> enemyChoices = enemyInput.enemyChoices();

        List<RockPaperScissorsResult> results = new ArrayList<>();

        while (playerChoices.hasNext() && enemyChoices.hasNext()) {
            RockPaperScissors playerChoice = playerChoices.next();
            RockPaperScissors enemyChoice = enemyChoices.next();

            RockPaperScissorsResult result = RockPaperScissorsResult.of(playerChoice, enemyChoice);

            results.add(result);
        }

        return Collections.unmodifiableList(results);
    }

}
