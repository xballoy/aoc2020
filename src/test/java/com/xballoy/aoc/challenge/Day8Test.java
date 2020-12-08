package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 8")
class Day8Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                nop +0
                acc +1
                jmp +4
                acc +3
                jmp -3
                acc -99
                acc +1
                jmp -4
                acc +6
                """;
        }

        @Test
        void part1_shouldFindValueBeforeExecutingOperationTwice() {
            // Arrange
            final Day cut = new Day8(new InputSupplier(() -> this.input));

            // Act
            final int result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(5);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day8.txt").get();
        }

        @Test
        void part1_shouldFindValueBeforeExecutingOperationTwice() {
            // Arrange
            final Day cut = new Day8(new InputSupplier(() -> input));

            // Act
            final int result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(1451);
        }
    }
}
