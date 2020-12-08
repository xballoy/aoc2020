package com.xballoy.aoc.challenge.day7;

import com.xballoy.aoc.AdventOfCodeException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RuleParser implements Function<String, Rule> {

    private static final Pattern BAG_TYPE_PATTERN = Pattern.compile("^(?<type>[a-z ]+) bags contain .*$");
    private static final Pattern NO_OTHER_PATTERN = Pattern.compile("^no other bags.$");
    private static final Pattern CONTENT_PATTERN = Pattern.compile("^(?<number>[0-9]) (?<type>[a-z ]+) bags?$");

    @Override
    public Rule apply(final String input) {
        final Matcher matcher = BAG_TYPE_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new AdventOfCodeException(String.format("No match found for %s", input));
        }

        final String type = matcher.group("type");

        String contentRule = input.split(" bags contain ")[1];

        Map<String, Integer> content;
        if (NO_OTHER_PATTERN.matcher(contentRule).matches()) {
            content = new HashMap<>();
        } else {
            content = new HashMap<>();

            final List<String> rules = Arrays.stream(contentRule.replace(".", "")
                .split(","))
                .map(String::trim)
                .collect(Collectors.toList());

            for (String rule : rules) {
                final Matcher ruleMatcher = CONTENT_PATTERN.matcher(rule);
                if (!ruleMatcher.matches()) {
                    throw new AdventOfCodeException(String.format("No match found for %s", input));
                }

                content.put(
                    ruleMatcher.group("type"),
                    Integer.valueOf(ruleMatcher.group("number"))
                );
            }
        }

        return new Rule(type, content);
    }
}
