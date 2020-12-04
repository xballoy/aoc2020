package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 2")
class Day2Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                1-3 a: abcde
                1-3 b: cdefg
                2-9 c: ccccccccc
                """;
        }

        @Test
        void part1_shouldFindValidPasswordCount() {
            // Arrange
            final Day2 cut = new Day2(new InputSupplier(() -> input));

            // Act
            final int validPassword = cut.part1FindValidPassword();

            // Asset
            assertThat(validPassword).isEqualTo(2);
        }

        @Test
        void part2_shouldFindValidPasswordCount() {
            // Arrange
            final Day2 cut = new Day2(new InputSupplier(() -> input));

            // Act
            final int validPassword = cut.part2FindValidPassword();

            // Asset
            assertThat(validPassword).isEqualTo(1);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day2.txt").get();
        }

        @Test
        void part1_shouldFindValidPasswordCount() {
            // Arrange
            final Day2 cut = new Day2(new InputSupplier(() -> input));

            // Act
            final int validPassword = cut.part1FindValidPassword();

            // Asset
            assertThat(validPassword).isEqualTo(614);
        }

        @Test
        void part2_shouldFindValidPasswordCount() {
            // Arrange
            final Day2 cut = new Day2(new InputSupplier(() -> input));

            // Act
            final int validPassword = cut.part2FindValidPassword();

            // Asset
            assertThat(validPassword).isEqualTo(354);
        }
    }
}
