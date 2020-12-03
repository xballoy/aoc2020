package com.xballoy.aoc.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {

    @Test
    void part1_shouldFindPairThatSum2020() {
        // Arrange
        final String input = """
            1721
            979
            366
            299
            675
            1456
            """;

        final Day1 cut = new Day1(() -> input);

        // Act
        final long result = cut.findPair();

        // Assert
        assertThat(result).isEqualTo(514579);
    }

    @Test
    void part2_shouldFindTripleThatSum2020() {
        // Arrange
        final String input = """
            1721
            979
            366
            299
            675
            1456
            """;

        final Day1 cut = new Day1(() -> input);

        // Act
        final long result = cut.findTriple();

        // Assert
        assertThat(result).isEqualTo(241861950);
    }
}
