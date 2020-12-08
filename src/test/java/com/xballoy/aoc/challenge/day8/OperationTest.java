package com.xballoy.aoc.challenge.day8;

import com.xballoy.aoc.AdventOfCodeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class OperationTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        "XXX"
    })
    void shouldThrowException_whenInvalidOperation(final String input) {
        // Act
        final Throwable throwable = catchThrowable(() -> Operation.of(input));

        // Assert
        assertThat(throwable).isInstanceOf(AdventOfCodeException.class);
    }

    @ParameterizedTest
    @EnumSource(Operation.class)
    void shouldReturnOperation(final Operation input) {
        // Act
        final Operation result = Operation.of(input.name());

        // Assert
        assertThat(result).isEqualTo(input);
    }
}
