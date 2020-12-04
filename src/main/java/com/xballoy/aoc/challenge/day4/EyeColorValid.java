package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EyeColorValid implements Predicate<String> {

    private static final Pattern COLOR_PATTERN = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");

    @Override
    public boolean test(final String input) {
        if(input == null) {
            return false;
        }

        return COLOR_PATTERN.matcher(input).matches();
    }
}
