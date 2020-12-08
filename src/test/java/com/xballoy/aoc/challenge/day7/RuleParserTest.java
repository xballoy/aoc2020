package com.xballoy.aoc.challenge.day7;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class RuleParserTest {

    private RuleParser cut;

    @BeforeEach
    void setUp() {
        this.cut = new RuleParser();
    }

    @Test
    void shouldParse_whenNoOtherBag(final SoftAssertions softly) {
        // Arrange
        final String input = "dotted black bags contain no other bags.";

        // Act
        final Rule rule = this.cut.apply(input);

        // Assert
        softly.assertThat(rule.getBagType()).isEqualTo("dotted black");
        softly.assertThat(rule.getContent()).isEmpty();
    }

    @Test
    void shouldParse_whenOneOtherBagSingular(final SoftAssertions softly) {
        // Arrange
        final String input = "bright white bags contain 1 shiny gold bag.";

        // Act
        final Rule rule = this.cut.apply(input);

        // Assert
        softly.assertThat(rule.getBagType()).isEqualTo("bright white");
        softly.assertThat(rule.getContent()).hasSize(1);
        softly.assertThat(rule.getContent().get("shiny gold")).isEqualTo(1);
    }

    @Test
    void shouldParse_whenOneOtherBagPlural(final SoftAssertions softly) {
        // Arrange
        final String input = "bright white bags contain 2 shiny gold bags.";

        // Act
        final Rule rule = this.cut.apply(input);

        // Assert
        softly.assertThat(rule.getBagType()).isEqualTo("bright white");
        softly.assertThat(rule.getContent()).hasSize(1);
        softly.assertThat(rule.getContent().get("shiny gold")).isEqualTo(2);
    }

    @Test
    void shouldParse_whenSeveralOtherBags(final SoftAssertions softly) {
        // Arrange
        final String input = "bright white bags contain 2 shiny gold bags, 9 faded blue bags";

        // Act
        final Rule rule = this.cut.apply(input);

        // Assert
        softly.assertThat(rule.getBagType()).isEqualTo("bright white");
        softly.assertThat(rule.getContent()).hasSize(2);
        softly.assertThat(rule.getContent().get("shiny gold")).isEqualTo(2);
        softly.assertThat(rule.getContent().get("faded blue")).isEqualTo(9);
    }
}
