package com.xballoy.aoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("InputFileSupplier")
class InputFileSupplierTest {

    @Test
    void shouldThrowException_whenFileDoesntExist() {
        // Arrange
        final String fileName = "does_not_exit.txt";
        final InputFileSupplier cut = new InputFileSupplier(fileName);

        // Act
        final Throwable throwable = catchThrowable(cut::get);

        // Assert
        assertThat(throwable).isInstanceOf(AdventOfCodeException.class);
    }

    @Test
    void shouldReturnFileContent() {
        // Arrange
        final String fileName = "sample_file.txt";
        final InputFileSupplier cut = new InputFileSupplier(fileName);

        // Act
        final String result = cut.get();

        // Assert
        assertThat(result).isEqualTo("Sample file");
    }
}
