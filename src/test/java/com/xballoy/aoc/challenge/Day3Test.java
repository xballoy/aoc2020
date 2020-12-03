package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 3")
class Day3Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                ..##.......
                #...#...#..
                .#....#..#.
                ..#.#...#.#
                .#...##..#.
                ..#.##.....
                .#.#.#....#
                .#........#
                #.##...#...
                #...##....#
                .#..#...#.#
                """;
        }

        @Test
        void part1_shouldSlideWithSlopeR3B1() {
            // Arrange
            final Day3 cut = new Day3(() -> input);

            // Act
            int encounteredTrees = cut.slide();

            // Assert
            assertThat(encounteredTrees).isEqualTo(7);
        }
    }

    @Disabled
    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day3.txt").get();
        }

        @Test
        void part1_shouldSlideWithSlopeR3B1() {
            // Arrange
            final Day3 cut = new Day3(() -> input);

            // Act
            int encounteredTrees = cut.slide();

            // Assert
            assertThat(encounteredTrees).isEqualTo(193);
        }

    }

}
