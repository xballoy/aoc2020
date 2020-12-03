package com.xballoy.aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("InputToStrings")
class InputToStringsTest {

    private InputToStrings cut;

    @BeforeEach
    void setUp() {
        this.cut = new InputToStrings();
    }

    @Test
    void shouldReturnListOfString() {
        // Arrange
        final String input = """
            a
            b
            c
            d
            e
            """;

        // Act
        final List<String> result = this.cut.apply(input);

        // Assert
        assertThat(result).containsExactly("a", "b", "c", "d", "e");
    }
}
