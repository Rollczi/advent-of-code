package dev.rollczi.adventofcode2022.day01;

import dev.rollczi.adventofcode2022.day01.elf.Elf;
import dev.rollczi.adventofcode2022.day01.elf.ElfRegistry;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import java.util.Scanner;

public class Day01 {

    public static void main(String[] args) throws FileNotFoundException {
        ElfRegistry registry = new ElfRegistry();
        Scanner scanner = new Scanner(new FileReader("2022/resources/day1/input.txt"));

        Elf elf = registry.createElf();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            try {
                int calories = Integer.parseInt(line);
                elf.addCalories(calories);
            }
            catch (NumberFormatException ignored) {
                elf = registry.createElf();
            }
        }

        scanner.close();

        Optional<Elf> withMostCalories = registry.getElfWithMostCalories();

        if (withMostCalories.isPresent()) {
            System.out.println("Elf with most calories: " + withMostCalories.get().getCalories());
        } else {
            System.out.println("No elves found");
        }
    }

}
