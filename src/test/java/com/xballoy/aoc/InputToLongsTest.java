package com.xballoy.aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("InputToLongs")
class InputToLongsTest {

    private InputToLongs cut;

    @BeforeEach
    void setUp() {
        this.cut = new InputToLongs();
    }

    @Test
    void shouldReturnListOfString() {
        // Arrange
        final String input = """
            1
            2
            3
            4
            5
            """;

        // Act
        final List<Long> result = this.cut.apply(input);

        // Assert
        assertThat(result).containsExactly(1L, 2L, 3L, 4L, 5L);
    }

}
