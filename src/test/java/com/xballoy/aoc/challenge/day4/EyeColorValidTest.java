package com.xballoy.aoc.challenge.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("EyeColorValid")
class EyeColorValidTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        "XXX"
    })
    void shouldBeInvalid_when(final String input) {
        // Arrange
        EyeColorValid cut = new EyeColorValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "amb",
        "blu",
        "brn",
        "gry",
        "grn",
        "hzl",
        "oth",
    })
    void shouldBeValid_when(final String input) {
        // Arrange
        EyeColorValid cut = new EyeColorValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isTrue();
    }

}
