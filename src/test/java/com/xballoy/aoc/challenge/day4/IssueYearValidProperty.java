package com.xballoy.aoc.challenge.day4;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.assertj.core.api.Assertions.assertThat;

@Label("IssueYearValid")
class IssueYearValidProperty {

    @Property
    void shouldBeValid(@ForAll @IntRange(min = 2010, max = 2020) int issueYear) {
        // Arrange
        IssueYearValid cut = new IssueYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(issueYear));

        // Asset
        assertThat(valid).isTrue();
    }

    @Property
    void shouldBeInvalid_whenBefore2009(@ForAll @IntRange(max = 2009) int issueYear) {
        // Arrange
        IssueYearValid cut = new IssueYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(issueYear));

        // Asset
        assertThat(valid).isFalse();
    }

    @Property
    void shouldBeInvalid_whenAfter2021(@ForAll @IntRange(min = 2021) int issueYear) {
        // Arrange
        IssueYearValid cut = new IssueYearValid();

        // Act
        final boolean valid = cut.test(String.valueOf(issueYear));

        // Asset
        assertThat(valid).isFalse();
    }
}
