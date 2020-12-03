package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToStrings;
import com.xballoy.aoc.challenge.day2.Policy;
import com.xballoy.aoc.challenge.day2.ToPolicy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Day2 {

    private final List<Policy> policies;

    public Day2(Supplier<String> inputSupplier) {
        final String input = inputSupplier.get();

        final ToPolicy toPolicy = new ToPolicy();
        this.policies = new InputToStrings()
            .andThen(strings -> strings.stream()
                .map(toPolicy)
                .collect(Collectors.toList()))
            .apply(input);
    }

    public int part1FindValidPassword() {
        int valid = 0;

        for (Policy policy : policies) {
            final Map<Character, Long> passwordMappedByChar = policy.getPassword().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            final long countLetter = Optional.ofNullable(passwordMappedByChar.get(policy.getLetter()))
                .orElseGet(() -> 0L);

            if(countLetter >= policy.getMin() && countLetter <= policy.getMax()) {
                valid += 1;
            }
        }

        return valid;
    }

    public int part2FindValidPassword() {
        int valid = 0;

        for (Policy policy : policies) {
            final char[] passwordChars = policy.getPassword().toCharArray();

            boolean pos1Matches = passwordChars[policy.getMin() - 1] == policy.getLetter();
            boolean pos2Matches = passwordChars[policy.getMax() -1] == policy.getLetter();

            if(pos1Matches ^ pos2Matches) {
                valid += 1;
            }
        }

        return valid;
    }

}
