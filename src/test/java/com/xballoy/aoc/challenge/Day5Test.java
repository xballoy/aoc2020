package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 5")
class Day5Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        @Test
        void part1_shouldFindSeat() {
            // Arrange
            // BFFFBBFRRR -> row 70, column 7, ID 567
            // FFFBBBFRRR, 14, 7, 119
            // BBFFBBFRLL, 102, 4, 820
            final String input = """
                BFFFBBFRRR
                FFFBBBFRRR
                BBFFBBFRLL
                """;
            final Day5 cut = new Day5(new InputSupplier(() -> input));

            // Act
            final int highestSeatId = cut.part1();

            // Assert
            assertThat(highestSeatId).isEqualTo(820);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day5.txt").get();
        }

        @Test
        void part1_shouldFindSeat() {
            final Day5 cut = new Day5(new InputSupplier(() -> input));

            // Act
            final int highestSeatId = cut.part1();

            // Assert
            assertThat(highestSeatId).isEqualTo(864);
        }
    }
}
