package com.xballoy.aoc.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    @Test
    void part1_shouldFindValidPasswordCount() {
        // Arrange
        final String input = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
            """;
        final Day2 cut = new Day2(() -> input);

        // Act
        final int validPassword = cut.part1FindValidPassword();

        // Asset
        assertThat(validPassword).isEqualTo(2);
    }

    @Test
    void part2_shouldFindValidPasswordCount() {
        // Arrange
        final String input = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
            """;
        final Day2 cut = new Day2(() -> input);

        // Act
        final int validPassword = cut.part2FindValidPassword();

        // Asset
        assertThat(validPassword).isEqualTo(1);
    }
}
