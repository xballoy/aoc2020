package com.xballoy.aoc.challenge.day4;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightValid implements Predicate<String> {

    private static final Pattern PATTERN_CM = Pattern.compile("^(?<size>\\d+)(cm)$");
    public static final int MIN_CM_SIZE = 150;
    public static final int MAX_CM_SIZE = 193;

    private static final Pattern PATTERN_IN = Pattern.compile("^(?<size>\\d+)(in)$");
    public static final int MIN_IN_SIZE = 59;
    public static final int MAX_IN_SIZE = 76;

    @Override
    public boolean test(final String input) {
        if(input == null) {
            return false;
        }

        final Matcher cmMatcher = PATTERN_CM.matcher(input);
        if(cmMatcher.matches()) {
            return validCmSize(Integer.parseInt(cmMatcher.group("size")));
        }

        final Matcher inMatcher = PATTERN_IN.matcher(input);
        if(inMatcher.matches()) {
            return validInSize(Integer.parseInt(inMatcher.group("size")));
        }

        return false;
    }

    private boolean validCmSize(final int size) {
        return size >= MIN_CM_SIZE && size <= MAX_CM_SIZE;
    }

    private boolean validInSize(final int size) {
        return size >= MIN_IN_SIZE && size <= MAX_IN_SIZE;
    }
}
