package com.xballoy.aoc.challenge.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("IssueYearValid")
class IssueYearValidTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "XXX")
    void shouldBeInvalid_when(final String input) {
        // Arrange
        IssueYearValid cut = new IssueYearValid();

        // Act
        final boolean valid = cut.test(input);

        // Asset
        assertThat(valid).isFalse();
    }
}
