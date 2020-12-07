package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.MapInputToGroup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 implements Day {

    private final List<List<String>> input;

    public Day6(final InputSupplier inputSupplier) {
        MapInputToGroup mapInputToGroup =new MapInputToGroup();
        this.input = mapInputToGroup.apply(inputSupplier.get()
            .collect(Collectors.toList())
        );
    }

    @Override
    public int part1() {
        int distinctAnswer = 0;
        for (List<String> group : input) {
                distinctAnswer += Arrays.stream(String.join("", group).split(""))
                    .distinct()
                    .collect(Collectors.joining())
                    .length();
            }

        return distinctAnswer;
    }

    @Override
    public int part2() {
        return 0;
    }
}
