package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;

public class BirthYearValid implements Predicate<String> {

    private final YearValid yearValid;

    public BirthYearValid() {
        this.yearValid = new YearValid(1920, 2002);
    }

    @Override
    public boolean test(final String input) {
        return yearValid.test(input);
    }
}
