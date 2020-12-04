package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;

public class ExpirationYearValid implements Predicate<String> {

    private final YearValid yearValid;

    public ExpirationYearValid() {
        this.yearValid = new YearValid(2020, 2030);
    }

    @Override
    public boolean test(final String input) {
        return yearValid.test(input);
    }
}
