package com.xballoy.aoc.challenge;

import com.xballoy.aoc.AdventOfCodeException;
import com.xballoy.aoc.InputSupplier;

import java.util.List;
import java.util.stream.Collectors;

public class Day9 {

    private final List<Long> numbers;

    public Day9(final InputSupplier inputSupplier) {
        this.numbers = inputSupplier.get()
            .map(Long::parseLong)
            .collect(Collectors.toList());
    }

    public long part1(final int preamble) {
        for (int i = preamble; i < numbers.size(); i++) {
            List<Long> findPairIn = numbers.subList(i - preamble, i + 1);
            final Long expectedNumber = numbers.get(i);

            boolean valid = foo(expectedNumber, findPairIn);
            if(!valid) {
                return expectedNumber;
            }
        }

        throw new AdventOfCodeException("Unable to find a solution");
    }

    private boolean foo(final Long expected, final List<Long> searchIn) {
        for (int i = 0; i < searchIn.size(); i++) {
            for (int j = 0; j < searchIn.size(); j++) {
                if(i == j) {
                    continue;
                }

                if(searchIn.get(i) + searchIn.get(j) == expected) {
                    return true;
                }
            }
        }

        return false;
    }
}
