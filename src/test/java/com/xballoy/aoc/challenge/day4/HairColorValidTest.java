package com.xballoy.aoc.challenge.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HairColorValid")
class HairColorValidTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        "XXX",
        "000000",
        "#00000",
        "#0000",
        "#000",
        "#00",
        "#0",
        "#",
        "#ggggg",
    })
    void shouldBeInvalid_when(final String input) {
        // Arrange
        HairColorValid cut = new HairColorValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "#000000",
        "#ffffff",
    })
    void shouldBeValid_when(final String input) {
        // Arrange
        HairColorValid cut = new HairColorValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isTrue();
    }
}
