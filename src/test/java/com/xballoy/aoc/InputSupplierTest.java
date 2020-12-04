package com.xballoy.aoc;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputSupplierTest {

    @Test
    void shouldReturnStream_whenInput() {
        // Arrange
        final String input = """
            a
            b
            c
            d
            e
            """;
        final InputSupplier cut = new InputSupplier(() -> input);

        // Act
        final Stream<String> stringStream = cut.get();

        // Assert
        assertThat(stringStream).containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    void shouldReturnEmptyStream_whenInputNull() {
        // Arrange
        final InputSupplier cut = new InputSupplier(() -> null);

        // Act
        final Stream<String> stringStream = cut.get();

        // Assert
        assertThat(stringStream).isEmpty();
    }
}
