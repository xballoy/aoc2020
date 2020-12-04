package com.xballoy.aoc.challenge.day4;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static com.xballoy.aoc.challenge.day4.HeightValid.*;
import static org.assertj.core.api.Assertions.assertThat;

@Label("HeightValid")
class HeightValidProperty {

    @Property
    void shouldBeValidCmSize(@ForAll @IntRange(min = MIN_CM_SIZE, max = MAX_CM_SIZE) int input) {
        // Arrange
        final HeightValid cut = new HeightValid();
        final String size = String.format("%scm", input);

        // Act
        final boolean valid = cut.test(size);

        // Assert
        assertThat(valid).isTrue();
    }

    @Property
    void shouldBeInvalidCmSize_whenTooSmall(@ForAll @IntRange(max = MIN_CM_SIZE - 1) int input) {
        // Arrange
        final HeightValid cut = new HeightValid();
        final String size = String.format("%scm", input);

        // Act
        final boolean valid = cut.test(size);

        // Assert
        assertThat(valid).isFalse();
    }

    @Property
    void shouldBeInvalidCmSize_whenTooBig(@ForAll @IntRange(min = MAX_CM_SIZE + 1) int input) {
        // Arrange
        final HeightValid cut = new HeightValid();
        final String size = String.format("%scm", input);

        // Act
        final boolean valid = cut.test(size);

        // Assert
        assertThat(valid).isFalse();
    }

    @Property
    void shouldBeValidInSize(@ForAll @IntRange(min = MIN_IN_SIZE, max = MAX_IN_SIZE) int input) {
        // Arrange
        final HeightValid cut = new HeightValid();
        final String size = String.format("%sin", input);

        // Act
        final boolean valid = cut.test(size);

        // Assert
        assertThat(valid).isTrue();
    }

    @Property
    void shouldBeInvalidInSize_whenTooSmall(@ForAll @IntRange(max = MIN_IN_SIZE - 1) int input) {
        // Arrange
        final HeightValid cut = new HeightValid();
        final String size = String.format("%sin", input);

        // Act
        final boolean valid = cut.test(size);

        // Assert
        assertThat(valid).isFalse();
    }

    @Property
    void shouldBeInvalidInSize_whenTooBig(@ForAll @IntRange(min = MAX_IN_SIZE + 1) int input) {
        // Arrange
        final HeightValid cut = new HeightValid();
        final String size = String.format("%sin", input);

        // Act
        final boolean valid = cut.test(size);

        // Assert
        assertThat(valid).isFalse();
    }
}
