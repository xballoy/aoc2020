package com.xballoy.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputToStrings implements Function<String, List<String>> {

    @Override
    public List<String> apply(final String input) {
        return Arrays.stream(input.split("\n"))
            .collect(Collectors.toList());
    }


}
