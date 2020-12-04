package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day3.Slope;
import com.xballoy.aoc.challenge.day3.ToTobogganMap;
import com.xballoy.aoc.challenge.day3.TobogganMap;

import java.util.List;
import java.util.stream.Collectors;

public class Day3 {

    private final TobogganMap tobogganMap;

    public Day3(final InputSupplier inputSupplier) {
        this.tobogganMap = new ToTobogganMap()
            .apply(inputSupplier.get().collect(Collectors.toList()));
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
