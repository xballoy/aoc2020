package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToLongs;
import com.xballoy.core.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Supplier;

public class Day1 {

    private static final Logger LOGGER = LogManager.getLogger(Day1.class);
    private static final long EXPECTED_RESULT = 2020;

    private final List<Long> numbers;

    public Day1(Supplier<String> inputSupplier) {
        final String input = inputSupplier.get();
        this.numbers = new InputToLongs().apply(input);
    }

    public long findPair() {
        for (long i : numbers) {
            for (long j : numbers) {
                if (i + j == EXPECTED_RESULT) {
                    return i * j;
                }
            }
        }

        return 0;
    }

    public long findTriple() {
        for (long i : numbers) {
            for (long j : numbers) {
                for (long k : numbers) {
                    if (i + j + k == EXPECTED_RESULT) {
                        return i * j * k;
                    }
                }
            }
        }
        return 0;
    }

    public void run() {
        StopWatch stopWatch = new StopWatch();
        LOGGER.info("Running day 1");

        stopWatch.start("Part 1");
        final long part1Result = this.findPair();
        stopWatch.stop();

        LOGGER.info(String.format("Part 1 result: %s", part1Result));
        LOGGER.info(String.format("Part 1 took %d ms", stopWatch.getLastTaskTimeMillis()));

        stopWatch.start("Part 2");
        final long part2Result = this.findTriple();
        stopWatch.stop();

        LOGGER.info(String.format("Part 2 result: %s", part2Result));
        LOGGER.info(String.format("Part 2 took %d ms", stopWatch.getLastTaskTimeMillis()));
    }
}
