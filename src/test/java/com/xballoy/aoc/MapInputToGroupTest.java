package com.xballoy.aoc;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SoftAssertionsExtension.class)
class MapInputToGroupTest {

    @Test
    void shouldGroup_whenUsingDefaultSeparator(final SoftAssertions softly) {
        // Arrange
        final List<String> input = Arrays.asList(
            "a",
            "b",
            "",
            "c",
            "d",
            "",
            "e"
        );
        final MapInputToGroup cut = new MapInputToGroup();

        // Act
        final List<List<String>> result = cut.apply(input);

        // Assert
        softly.assertThat(result).hasSize(3);
        softly.assertThat(result.get(0)).containsExactly("a", "b");
        softly.assertThat(result.get(1)).containsExactly("c", "d");
        softly.assertThat(result.get(2)).containsExactly("e");
    }

    @Test
    void shouldGroup_whenUsingCustomSeparator(final SoftAssertions softly) {
        // Arrange
        final List<String> input = Arrays.asList(
            "a",
            "b",
            "-",
            "c",
            "d",
            "-",
            "e"
        );
        final MapInputToGroup cut = new MapInputToGroup("-");

        // Act
        final List<List<String>> result = cut.apply(input);

        // Assert
        softly.assertThat(result).hasSize(3);
        softly.assertThat(result.get(0)).containsExactly("a", "b");
        softly.assertThat(result.get(1)).containsExactly("c", "d");
        softly.assertThat(result.get(2)).containsExactly("e");
    }
}
