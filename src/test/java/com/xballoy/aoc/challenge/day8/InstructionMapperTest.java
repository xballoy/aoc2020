package com.xballoy.aoc.challenge.day8;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class InstructionMapperTest {

    private InstructionMapper cut;

    @BeforeEach
    void setUp() {
        this.cut = new InstructionMapper();
    }

    @Test
    void shouldParseInstruction_whenPositiveArg(final SoftAssertions softly) {
        // Arrange
        final String input = "acc +1";

        // Act
        final Instruction instruction = this.cut.apply(input);

        // Assert
        softly.assertThat(instruction.getOperation()).isEqualTo(Operation.ACC);
        softly.assertThat(instruction.getArgument()).isEqualTo(1);
    }

    @Test
    void shouldParseInstruction_whenNegativeArg(final SoftAssertions softly) {
        // Arrange
        final String input = "acc -1";

        // Act
        final Instruction instruction = this.cut.apply(input);

        // Assert
        softly.assertThat(instruction.getOperation()).isEqualTo(Operation.ACC);
        softly.assertThat(instruction.getArgument()).isEqualTo(-1);
    }
}
