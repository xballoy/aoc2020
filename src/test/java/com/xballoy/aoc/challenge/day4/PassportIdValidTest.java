package com.xballoy.aoc.challenge.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PassportIdValid")
class PassportIdValidTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        "XXX",
        "0123456789"
    })
    void shouldBeInvalid_when(final String input) {
        // Arrange
        PassportIdValid cut = new PassportIdValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isFalse();
    }

    @Test
    void shouldBeValid() {
        // Arrange
        final String input = "000000001";
        PassportIdValid cut = new PassportIdValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isTrue();
    }

}
