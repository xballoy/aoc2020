package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PassportIdValid implements Predicate<String> {

    private static final Pattern PASSPORT_PATTERN = Pattern.compile("^\\d{9}$");

    @Override
    public boolean test(final String input) {
        if (input == null) {
            return false;
        }

        return PASSPORT_PATTERN.matcher(input).matches();
    }
}
