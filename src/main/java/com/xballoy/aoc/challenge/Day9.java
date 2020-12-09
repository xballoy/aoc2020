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
        return findInvalidNumber(preamble);
    }

    public long part2(final int preamble) {
        final long invalidNumber = findInvalidNumber(preamble);

        for (int start = 0; start < numbers.size(); start++) {
            for (int end = 0; end < numbers.size(); end++) {
                if(end - start < 2) {
                    continue;
                }

                final List<Long> subSet = numbers.subList(start, end)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
                final Long sumSubset = subSet.stream()
                    .reduce(0L, Long::sum);

                if(sumSubset == invalidNumber) {
                    return subSet.get(0) + subSet.get(subSet.size() - 1);
                }
            }
        }

        throw new AdventOfCodeException("Unable to find a solution");
    }

    private long findInvalidNumber(final int preamble) {
        for (int i = preamble; i < numbers.size(); i++) {
            List<Long> findPairIn = numbers.subList(i - preamble, i);
            final long expectedNumber = numbers.get(i);

            boolean valid = isValidNumber(expectedNumber, findPairIn);
            if(!valid) {
                return expectedNumber;
            }
        }

        throw new AdventOfCodeException("Unable to find a solution");
    }

    private boolean isValidNumber(final Long expected, final List<Long> searchIn) {
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
