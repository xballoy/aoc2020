package com.xballoy.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputToLongs implements Function<String, List<Long>> {

    @Override
    public List<Long> apply(final String input) {
        return Arrays.stream(input.split("\n"))
            .map(Long::parseLong)
            .collect(Collectors.toList());
    }


}
