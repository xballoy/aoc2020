package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.MapInputToGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day6 implements Day {

    private final List<List<String>> groups;

    public Day6(final InputSupplier inputSupplier) {
        MapInputToGroup mapInputToGroup = new MapInputToGroup();
        final List<String> sortedInputs = inputSupplier.get()
            .map(it -> Arrays.stream(it.split("")).sorted().collect(Collectors.joining()))
            .collect(Collectors.toList());

        this.groups = mapInputToGroup.apply(sortedInputs);
    }

    @Override
    public int part1() {
        int distinctAnswer = 0;
        for (List<String> group : groups) {
            distinctAnswer += Arrays.stream(String.join("", group).split(""))
                .distinct()
                .collect(Collectors.joining())
                .length();
        }

        return distinctAnswer;
    }

    @Override
    public int part2() {
        int count = 0;
        for (List<String> group : groups) {
            final Map<String, Long> collect = group.stream()
                .flatMap(it -> Arrays.stream(it.split("")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            count += collect.values().stream()
                .filter(it -> it == group.size())
                .count();
        }

        return count;
    }
}
