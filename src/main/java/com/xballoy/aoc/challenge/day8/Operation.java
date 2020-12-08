package com.xballoy.aoc.challenge.day8;

import com.xballoy.aoc.AdventOfCodeException;

import java.util.Arrays;

public enum Operation {
    ACC,
    JMP,
    NOP;

    public static Operation of(final String operation) {
        return Arrays.stream(values())
            .filter(o -> o.name().equalsIgnoreCase(operation))
            .findFirst()
            .orElseThrow(() -> new AdventOfCodeException(String.format("Operation %s not found", operation)));
    }
}
