package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;

public class YearValid implements Predicate<String> {

    private final int min;
    private final int max;

    public YearValid(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean test(final String input) {
        if(input == null) {
            return false;
        }

        try {
            final int birthDate = Integer.parseInt(input);
            return birthDate >= min && birthDate <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
