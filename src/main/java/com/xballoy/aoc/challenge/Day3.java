package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToStrings;
import com.xballoy.aoc.challenge.day3.ToTobogganMap;
import com.xballoy.aoc.challenge.day3.TobogganMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class Day3 {

    private static final Logger LOGGER = LogManager.getLogger(Day3.class);

    private final TobogganMap tobogganMap;

    public Day3(Supplier<String> inputSupplier) {
        final String input = inputSupplier.get();
        this.tobogganMap = new InputToStrings()
            .andThen(new ToTobogganMap())
            .apply(input);
    }

    private static final int SLOPE_RIGHT = 3;
    private static final int SLOPE_DOWN = 1;

    public int slide() {
        int encounteredTrees = 0;

        int x = 1;
        int y = 1;
        do {
            x += SLOPE_RIGHT;
            y += SLOPE_DOWN;

            if (tobogganMap.isTreeAtPosition(y, x)) {
                LOGGER.info("X : (x, y) = ({},{})", x, y);
                encounteredTrees++;
            } else {
                LOGGER.info("O : (x, y) = ({},{})", x, y);
            }
        } while (y < tobogganMap.rows());

        return encounteredTrees;
    }
}
