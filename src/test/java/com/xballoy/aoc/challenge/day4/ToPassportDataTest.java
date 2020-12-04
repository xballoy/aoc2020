package com.xballoy.aoc.challenge.day4;

import com.xballoy.aoc.InputToStrings;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Map;

@ExtendWith(SoftAssertionsExtension.class)
class ToPassportDataTest {

    @Test
    void shouldReturnListPasswordData(final SoftAssertions softly) {
        // Arrange
        final String input = """
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
        final List<String> lines = new InputToStrings().apply(input);

        // Act
        final List<Map<String, String>> passwords = new ToPassportData().apply(lines);

        // Assert
        softly.assertThat(passwords).hasSize(4);

        softly.assertThat(passwords.get(0)).containsOnlyKeys("ecl", "pid", "eyr", "hcl", "byr", "iyr", "cid", "hgt");
        softly.assertThat(passwords.get(1)).containsOnlyKeys("ecl", "pid", "eyr", "hcl", "byr", "iyr", "cid");
        softly.assertThat(passwords.get(2)).containsOnlyKeys("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt");
        softly.assertThat(passwords.get(3)).containsOnlyKeys("ecl", "pid", "eyr", "hcl", "iyr", "hgt");
    }
}
