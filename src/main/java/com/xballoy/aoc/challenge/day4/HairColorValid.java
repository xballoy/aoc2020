package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class HairColorValid implements Predicate<String> {

    private static final Pattern COLOR_PATTERN = Pattern.compile("^#[a-f0-9]{6}$");

    @Override
    public boolean test(final String input) {
        if(input == null) {
            return false;
        }

        return COLOR_PATTERN.matcher(input).matches();
    }
}
