package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 1")
class Day1Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
            1721
            979
            366
            299
            675
            1456
            """;
        }

        @Test
        void part1_shouldFindPairThatSum2020() {
            // Arrange
            final Day1 cut = new Day1(() -> input);

            // Act
            final long result = cut.findPair();

            // Assert
            assertThat(result).isEqualTo(514579);
        }

        @Test
        void part2_shouldFindTripleThatSum2020() {
            // Arrange
            final Day1 cut = new Day1(() -> input);

            // Act
            final long result = cut.findTriple();

            // Assert
            assertThat(result).isEqualTo(241861950);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day1.txt").get();
        }

        @Test
        void part1_shouldFindPairThatSum2020() {
            // Arrange
            final Day1 cut = new Day1(() -> input);

            // Act
            final long result = cut.findPair();

            // Assert
            assertThat(result).isEqualTo(806656);
        }

        @Test
        void part2_shouldFindTripleThatSum2020() {
            // Arrange
            final Day1 cut = new Day1(() -> input);

            // Act
            final long result = cut.findTriple();

            // Assert
            assertThat(result).isEqualTo(230608320);
        }
    }
}
