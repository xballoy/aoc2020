package com.xballoy.aoc.challenge.day4;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.assertj.core.api.Assertions.assertThat;

@Label("ExpirationYearValid")
class ExpirationYearValidProperty {

    @Property
    void shouldBeValid(@ForAll @IntRange(min = 2020, max = 2030) int expirationYear) {
        // Arrange
        ExpirationYearValid cut = new ExpirationYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(expirationYear));

        // Asset
        assertThat(valid).isTrue();
    }

    @Property
    void shouldBeInvalid_whenBefore2019(@ForAll @IntRange(max = 2019) int expirationYear) {
        // Arrange
        ExpirationYearValid cut = new ExpirationYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(expirationYear));

        // Asset
        assertThat(valid).isFalse();
    }

    @Property
    void shouldBeInvalid_whenAfter2031(@ForAll @IntRange(min = 2031) int expirationYear) {
        // Arrange
        ExpirationYearValid cut = new ExpirationYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(expirationYear));

        // Asset
        assertThat(valid).isFalse();
    }
}
