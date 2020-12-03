package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.challenge.day3.Slope;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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

        @ParameterizedTest
        @CsvSource({
            "R1_D1, 2",
            "R3_D1, 7",
            "R5_D1, 3",
            "R7_D1, 4",
            "R1_D2, 2",
        })
        void part1_shouldSlideWithSlopeR3D1(final Slope slope, int expectedTrees) {
            // Arrange
            final Day3 cut = new Day3(() -> input);

            // Act
            int encounteredTrees = cut.slide(slope);

            // Assert
            assertThat(encounteredTrees).isEqualTo(expectedTrees);
        }

        @Test
        void part2_shouldTryMultipleSlope() {
            // Arrange
            final Day3 cut = new Day3(() -> input);

            // Act
            int encounteredTrees = cut.slide(Arrays.asList(
                Slope.R1_D1,
                Slope.R3_D1,
                Slope.R5_D1,
                Slope.R7_D1,
                Slope.R1_D2
            ));

            // Assert
            assertThat(encounteredTrees).isEqualTo(336);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day3.txt").get();
        }

        @Test
        void part1_shouldSlideWithSlopeR3D1() {
            // Arrange
            final Day3 cut = new Day3(() -> input);

            // Act
            int encounteredTrees = cut.slide(Slope.R3_D1);

            // Assert
            assertThat(encounteredTrees).isEqualTo(193);
        }

        @Test
        void part2_shouldTryMultipleSlope() {
            // Arrange
            final Day3 cut = new Day3(() -> input);

            // Act
            int encounteredTrees = cut.slide(Arrays.asList(
                Slope.R1_D1,
                Slope.R3_D1,
                Slope.R5_D1,
                Slope.R7_D1,
                Slope.R1_D2
            ));

            // Assert
            assertThat(encounteredTrees).isEqualTo(1355323200);
        }
    }

}
