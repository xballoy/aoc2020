package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 6")
class Day7Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                light red bags contain 1 bright white bag, 2 muted yellow bags.
                dark orange bags contain 3 bright white bags, 4 muted yellow bags.
                bright white bags contain 1 shiny gold bag.
                muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
                shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
                dark olive bags contain 3 faded blue bags, 4 dotted black bags.
                vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
                faded blue bags contain no other bags.
                dotted black bags contain no other bags.
                """;
        }

        @Test
        void part1_shouldFindHowManyBagsCanContainShinyGoldBag() {
            // Arrange
            final Day cut = new Day7(new InputSupplier(() -> this.input));

            // Act
            final int result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(4);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day7.txt").get();
        }

        @Test
        void part1_shouldFindHowManyBagsCanContainShinyGoldBag() {
            // Arrange
            final Day cut = new Day7(new InputSupplier(() -> this.input));

            // Act
            final int result = cut.part1();

            // Assert
            assertThat(result).isEqualTo(287);
        }
    }
}
