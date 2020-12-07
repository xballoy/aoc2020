package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    private final List<String> input;

    public Day6(final InputSupplier inputSupplier) {
        input = Arrays.stream(
            inputSupplier.get()
                .map(it -> "".equals(it) ? ";" : it)
                .collect(Collectors.joining(""))
                .split(";"))
            .collect(Collectors.toList());
    }

    public int part1() {
        int distinctAnswer = 0;
        for (String string : input) {
            distinctAnswer += Arrays.stream(string.split(""))
                .distinct()
                .collect(Collectors.joining())
                .length();

        }

        return distinctAnswer;
    }
}
