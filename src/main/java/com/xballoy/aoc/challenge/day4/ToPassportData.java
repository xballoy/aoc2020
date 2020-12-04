package com.xballoy.aoc.challenge.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToPassportData implements Function<List<String>, List<Map<String, String>>> {

    @Override
    public List<Map<String, String>> apply(final List<String> lines) {
        List<Map<String, String>> passports = new ArrayList<>();

        Map<String, String> passport = new HashMap<>();
        for (String line : lines) {
            if("".equals(line)) {
                passports.add(new HashMap<>(passport));
                passport.clear();
                continue;
            }

            final Map<String, String> partialPassportData = Arrays.stream(line.split(" "))
                .map(it -> it.split(":"))
                .collect(Collectors.toMap(p -> p[0], p -> p[1]));
            passport.putAll(partialPassportData);
        }

        passports.add(passport);
        return passports;
    }
}
