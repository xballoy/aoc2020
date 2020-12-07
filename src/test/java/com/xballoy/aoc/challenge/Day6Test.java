package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 6")
class Day6Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                abc

                a
                b
                c

                ba
                ac

                a
                a
                a
                a

                b
                """;
        }

        @Test
        void part1_shouldFindQuestionsAnyoneAnsweredYes() {
            // Arrange
            final Day cut = new Day6(new InputSupplier(() -> this.input));

            // Act
            final int result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(11);
        }

        @Test
        void part2_shouldFindQuestionsEveryoneAnsweredYes() {
            // Arrange
            final Day cut = new Day6(new InputSupplier(() -> this.input));

            // Act
            final int result = cut.part2();

            // Assert
            assertThat(result).isEqualTo(6);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day6.txt").get();
        }

        @Test
        void part1_shouldFindQuestionsAnyoneAnsweredYes() {
            // Arrange
            final Day cut = new Day6(new InputSupplier(() -> input));

            // Act
            final int result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(6775);
        }

        @Test
        void part2_shouldFindQuestionsEveryoneAnsweredYes() {
            // Arrange
            final Day cut = new Day6(new InputSupplier(() -> input));

            // Act
            final int result = cut.part2();

            // Assert
            assertThat(result).isEqualTo(3356);
        }
    }
}
