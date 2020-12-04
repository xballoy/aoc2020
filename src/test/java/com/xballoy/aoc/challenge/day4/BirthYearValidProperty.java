package com.xballoy.aoc.challenge.day4;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.assertj.core.api.Assertions.assertThat;

@Label("BirthYearValid")
class BirthYearValidProperty {

    @Property
    void shouldBeValid(@ForAll @IntRange(min = 1920, max = 2002) int birthDate) {
        // Arrange
        BirthYearValid cut = new BirthYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(birthDate));

        // Asset
        assertThat(valid).isTrue();
    }

    @Property
    void shouldBeInvalid_whenBefore1920(@ForAll @IntRange(max = 1919) int birthDate) {
        // Arrange
        BirthYearValid cut = new BirthYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(birthDate));

        // Asset
        assertThat(valid).isFalse();
    }

    @Property
    void shouldBeInvalid_whenAfter2002(@ForAll @IntRange(min = 2003) int birthDate) {
        // Arrange
        BirthYearValid cut = new BirthYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(birthDate));

        // Asset
        assertThat(valid).isFalse();
    }
}
