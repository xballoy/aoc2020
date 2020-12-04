package com.xballoy.aoc.challenge.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ExpirationYearValid")
class ExpirationYearValidTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "XXX")
    void shouldBeInvalid_when(final String input) {
        // Arrange
        ExpirationYearValid cut = new ExpirationYearValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isFalse();
    }
}
