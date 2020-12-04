package com.xballoy.aoc.challenge.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToPassportData implements Function<List<String>, List<Map<PassportAttribute, String>>> {

    @Override
    public List<Map<PassportAttribute, String>> apply(final List<String> lines) {
        List<Map<PassportAttribute, String>> passports = new ArrayList<>();

        Map<PassportAttribute, String> passport = new HashMap<>();
        for (String line : lines) {
            if("".equals(line)) {
                passports.add(new HashMap<>(passport));
                passport.clear();
                continue;
            }

            final Map<PassportAttribute, String> partialPassportData = Arrays.stream(line.split(" "))
                .map(it -> it.split(":"))
                .collect(Collectors.toMap(p -> PassportAttribute.fromKey(p[0]), p -> p[1]));
            passport.putAll(partialPassportData);
        }

        passports.add(passport);
        return passports;
    }
}
