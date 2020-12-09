package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 9")
class Day9Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                35
                20
                15
                25
                47
                40
                62
                55
                65
                95
                102
                117
                150
                182
                127
                219
                299
                277
                309
                576
                """;
        }

        @Test
        void part1_shouldFindValueWhichIsNotSumOfPreviousNumber() {
            // Arrange
            final Day9 cut = new Day9(new InputSupplier(() -> this.input));

            // Act
            final long result = cut.part1(5);

            // Assert
            assertThat(result).isEqualTo(127L);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day9.txt").get();
        }

        @Test
        void part1_shouldFindValueWhichIsNotSumOfPreviousNumber() {
            // Arrange
            final Day9 cut = new Day9(new InputSupplier(() -> this.input));

            // Act
            final long result = cut.part1(25);

            // Assert
            assertThat(result).isEqualTo(21806024L);
        }
    }
}
