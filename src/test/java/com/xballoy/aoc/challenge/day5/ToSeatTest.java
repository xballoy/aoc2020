package com.xballoy.aoc.challenge.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ToSeatTest {

    private ToSeat cut;

    @BeforeEach
    void setUp() {
        this.cut = new ToSeat();
    }

    @Test
    void shouldReturnSeat() {
        // Arrange
        final String input = "FBFBBFFRLR";

        // Act
        final Seat seat = this.cut.apply(input);

        // Assert
        assertThat(seat.getRow()).isEqualTo(44);
        assertThat(seat.getColumn()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 127, 63",
        "32, 63, 47",
    })
    void getLowerHalf_should(final int min, final int max, final int expected) {
        // Act
        final int lowerHalf = this.cut.getLowerHalf(min, max);

        // Assert
        assertThat(lowerHalf).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 63, 32",
        "32, 47, 40",
    })
    void getUpperHalf_should(final int min, final int max, final int expected) {
        // Act
        final int upperHalf = this.cut.getUpperHalp(min, max);

        // Assert
        assertThat(upperHalf).isEqualTo(expected);
    }
}
