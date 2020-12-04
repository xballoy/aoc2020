package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputFileSupplier;
import com.xballoy.aoc.InputSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Day 4")
class Day4Test {

    @DisplayName("Sample data")
    @Nested
    class SampleData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = """
                ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
                byr:1937 iyr:2017 cid:147 hgt:183cm

                iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
                hcl:#cfa07d byr:1929

                hcl:#ae17e1 iyr:2013
                eyr:2024
                ecl:brn pid:760753108 byr:1931
                hgt:179cm

                hcl:#cfa07d eyr:2025 pid:166559648
                iyr:2011 ecl:brn hgt:59in
                """;
        }

        @Test
        void part1_shouldValidatePassword() {
            // Arrange
            final Day4 cut = new Day4(new InputSupplier(() -> input));

            // Act
            int validPasswords = cut.part1ValidPassport();

            // Assert
            assertThat(validPasswords).isEqualTo(2);
        }

        @Test
        void part2_shouldValidatePasswordAttributes() {
            // Arrange
            final Day4 cut = new Day4(new InputSupplier(() -> input));

            // Act
            int validPasswords = cut.part2ValidPassport();

            // Assert
            assertThat(validPasswords).isEqualTo(2);
        }
    }

    @DisplayName("Real data")
    @Nested
    class RealData {

        private String input;

        @BeforeEach
        void setUp() {
            this.input = new InputFileSupplier("input/day4.txt").get();
        }

        @Test
        void part1_shouldValidatePassword() {
            // Arrange
            final Day4 cut = new Day4(new InputSupplier(() -> input));

            // Act
            int validPasswords = cut.part1ValidPassport();

            // Assert
            assertThat(validPasswords).isEqualTo(182);
        }

        @Test
        void part2_shouldValidatePasswordAttributes() {
            // Arrange
            final Day4 cut = new Day4(new InputSupplier(() -> input));

            // Act
            int validPasswords = cut.part2ValidPassport();

            // Assert
            assertThat(validPasswords).isEqualTo(109);
        }
    }
}
