package com.xballoy.aoc.challenge;

import com.xballoy.aoc.AdventOfCodeException;
import com.xballoy.aoc.InputSupplier;

import java.util.List;
import java.util.stream.Collectors;

public class Day10 implements Day {

    private List<Integer> adapters;

    public Day10(final InputSupplier inputSupplier) {
        this.adapters = inputSupplier.get()
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
    }

    @Override
    public int part1() {
        int difference1Jolt = 0;
        int difference3Jolts = 0;
        int currentJolt = 0;

        for (Integer adapter : adapters) {
            int difference = adapter - currentJolt;
            if (difference == 1) {
                difference1Jolt += 1;
            } else if (difference == 3) {
                difference3Jolts += 1;
            } else {
                throw new AdventOfCodeException(String.format("Found a difference of %s jolts", difference));
            }
            currentJolt = adapter;
        }

        return difference1Jolt * (difference3Jolts + 1);
    }

    @Override
    public int part2() {
        return 0;
    }
}
