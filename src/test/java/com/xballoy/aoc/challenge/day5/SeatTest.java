package com.xballoy.aoc.challenge.day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeatTest {

    @Test
    void getId_shouldReturnId() {
        // Arrange
        final Seat cut = new Seat(44, 5);

        // Act
        final int id = cut.getId();

        // Assert
        assertThat(id).isEqualTo(357);
    }
}
