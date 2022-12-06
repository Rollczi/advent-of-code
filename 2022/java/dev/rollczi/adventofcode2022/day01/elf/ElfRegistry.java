package dev.rollczi.adventofcode2022.day01.elf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ElfRegistry {

    private final List<Elf> elves = new ArrayList<>();

    public Elf createElf() {
        Elf elf = new Elf();
        elves.add(elf);

        return elf;
    }

    public Optional<Elf> getElfWithMostCalories() {
        return elves.stream()
            .max(Comparator.comparingInt(Elf::getCalories));
    }

}
