package com.xballoy.aoc.challenge.day8;

import com.xballoy.aoc.AdventOfCodeException;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionMapper implements Function<String, Instruction> {

    private static final Pattern OPERATION_PATTERN = Pattern.compile("^(?<operation>[a-z]+) (?<arg>[+-][0-9]*)$");

    @Override
    public Instruction apply(final String from) {
        final Matcher matcher = OPERATION_PATTERN.matcher(from);
        if (!matcher.matches()) {
            throw new AdventOfCodeException(String.format("No match found %s", from));
        }

        return new Instruction(
            Operation.of(matcher.group("operation")),
            Integer.parseInt(matcher.group("arg"))
        );
    }
}
