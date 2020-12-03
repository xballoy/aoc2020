package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToLongs;

import java.util.List;
import java.util.function.Supplier;

public class Day1 {

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
}
