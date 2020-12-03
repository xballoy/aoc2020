package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToStrings;
import com.xballoy.aoc.challenge.day3.Slope;
import com.xballoy.aoc.challenge.day3.ToTobogganMap;
import com.xballoy.aoc.challenge.day3.TobogganMap;

import java.util.List;
import java.util.function.Supplier;

public class Day3 {

    private final TobogganMap tobogganMap;

    public Day3(Supplier<String> inputSupplier) {
        final String input = inputSupplier.get();
        this.tobogganMap = new InputToStrings()
            .andThen(new ToTobogganMap())
            .apply(input);
    }

    public int slide(List<Slope> slopes) {
        return slopes.stream()
            .map(this::slide)
            .reduce(1, (a, b) -> a * b);
    }

    public int slide(Slope slope) {
        int encounteredTrees = 0;

        int x = 1;
        int y = 1;
        do {
            x += slope.getRight();
            y += slope.getDown();

            if (tobogganMap.isTreeAtPosition(y, x)) {
                encounteredTrees++;
            }
        } while (y < tobogganMap.rows());

        return encounteredTrees;
    }
}
