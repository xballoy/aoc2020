package com.xballoy.aoc.challenge.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountryIdValidTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "XXX")
    void shouldAlwaysBeValid(final String input) {
        // Arrange
        CountryIdValid cut = new CountryIdValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isTrue();
    }

}
