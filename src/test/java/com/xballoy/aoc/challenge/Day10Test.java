package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 10")
class Day10Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        @Test
        void part1_shouldFindDifferences1Jolt3Jolts_example1() {
            // Arrange
            final String input = """
                16
                10
                15
                5
                1
                11
                7
                19
                6
                12
                4
                """;
            final Day10 cut = new Day10(new InputSupplier(() -> input));

            // Act
            final double result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(35);
        }

        @Test
        void part1_shouldFindDifferences1Jolt3Jolts_example2() {
            // Arrange
            final String input = """
                28
                33
                18
                42
                31
                14
                46
                20
                48
                47
                24
                23
                49
                45
                19
                38
                39
                11
                1
                32
                25
                35
                8
                17
                7
                9
                4
                2
                34
                10
                3
                """;
            final Day10 cut = new Day10(new InputSupplier(() -> input));

            // Act
            final double result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(220);
        }

        @Test
        void part2_shouldFindNumberArrangements_example1() {
            // Arrange
            final String input = """
                16
                10
                15
                5
                1
                11
                7
                19
                6
                12
                4
                """;
            final Day10 cut = new Day10(new InputSupplier(() -> input));

            // Act
            final BigInteger result = cut.part2();

            // Assert
            assertThat(result).isEqualTo(new BigInteger("8"));
        }

        @Test
        void part2_shouldFindNumberArrangements_example2() {
            // Arrange
            final String input = """
                28
                33
                18
                42
                31
                14
                46
                20
                48
                47
                24
                23
                49
                45
                19
                38
                39
                11
                1
                32
                25
                35
                8
                17
                7
                9
                4
                2
                34
                10
                3
                """;
            final Day10 cut = new Day10(new InputSupplier(() -> input));

            // Act
            final BigInteger result = cut.part2();

            // Assert
            assertThat(result).isEqualTo(new BigInteger("19208"));
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day10.txt").get();
        }

        @Test
        void part1_shouldFindDifferences1Jolt3Jolts() {
            // Arrange
            final Day10 cut = new Day10(new InputSupplier(() -> this.input));

            // Act
            final double result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(1885);
        }

        @Test
        void part2_shouldFindNumberArrangements() {
            // Arrange
            final Day10 cut = new Day10(new InputSupplier(() -> this.input));

            // Act
            final BigInteger result = cut.part2();

            // Assert
            assertThat(result).isEqualTo(new BigInteger("2024782584832"));
        }

    }
}
