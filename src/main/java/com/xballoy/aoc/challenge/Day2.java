package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputToStrings;
import com.xballoy.aoc.challenge.day2.Policy;
import com.xballoy.aoc.challenge.day2.ToPolicy;
import com.xballoy.core.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Day2 {

    private static final Logger LOGGER = LogManager.getLogger(Day2.class);

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

    public void run() {
        StopWatch stopWatch = new StopWatch();
        LOGGER.info("Running day 2");

        stopWatch.start("Part 2");
        final int part1Result = this.part1FindValidPassword();
        stopWatch.stop();

        LOGGER.info(String.format("Part 1 result: %s", part1Result));
        LOGGER.info(String.format("Part 1 took %d ms", stopWatch.getLastTaskTimeMillis()));

        stopWatch.start("Part 2");
        final long part2Result = this.part2FindValidPassword();
        stopWatch.stop();

        LOGGER.info(String.format("Part 2 result: %s", part2Result));
        LOGGER.info(String.format("Part 2 took %d ms", stopWatch.getLastTaskTimeMillis()));
    }

}
