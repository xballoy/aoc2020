package com.xballoy.aoc.challenge.day2;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class ToPolicyTest {

    @Test
    void shouldMapPolicy(final SoftAssertions softly) {
        // Arrange
        final String input = "1-3 a: abcde";
        final ToPolicy cut = new ToPolicy();

        // Act
        final Policy policy = cut.apply(input);

        // Assert
        softly.assertThat(policy.getMin()).isEqualTo(1);
        softly.assertThat(policy.getMax()).isEqualTo(3);
        softly.assertThat(policy.getLetter()).isEqualTo('a');
        softly.assertThat(policy.getPassword()).isEqualTo("abcde");
    }
}
