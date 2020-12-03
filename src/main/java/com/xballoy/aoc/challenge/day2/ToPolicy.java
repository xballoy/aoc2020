package com.xballoy.aoc.challenge.day2;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToPolicy implements Function<String, Policy> {

    private static final Pattern POLICY_PATTERN = Pattern.compile("^(?<min>\\d+)-(?<max>\\d+) (?<letter>\\w): (?<pwd>\\w+)$");

    @Override
    public Policy apply(final String input) {
        final Matcher matcher = POLICY_PATTERN.matcher(input);
        if (!matcher.matches()) {
            return null;
        }

        return new Policy(
            Integer.parseInt(matcher.group("min")),
            Integer.parseInt(matcher.group("max")),
            matcher.group("letter").charAt(0),
            matcher.group("pwd")
        );
    }
}
