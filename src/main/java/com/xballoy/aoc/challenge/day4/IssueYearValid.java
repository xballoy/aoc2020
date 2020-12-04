package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;

public class IssueYearValid implements Predicate<String> {

    private final YearValid yearValid;

    public IssueYearValid() {
        this.yearValid = new YearValid(2010, 2020);
    }

    @Override
    public boolean test(final String input) {
        return yearValid.test(input);
    }
}
