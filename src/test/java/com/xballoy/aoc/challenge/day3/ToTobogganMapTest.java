package com.xballoy.aoc.challenge.day3;

import com.xballoy.aoc.InputToStrings;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@DisplayName("ToToTobogganMapTest")
@ExtendWith(SoftAssertionsExtension.class)
class ToTobogganMapTest {

    private ToTobogganMap cut;

    @BeforeEach
    void setUp() {
        this.cut = new ToTobogganMap();
    }

    @Test
    void shouldCreateToTobogganMap(final SoftAssertions softly) {
        // Arrange
        final String input = """
            ..##.......
            ...........
            #.........#
            """;
        final List<String> rows = new InputToStrings().apply(input);

        // Act
        final TobogganMap tobogganMap = this.cut.apply(rows);

        // Assert
        softly.assertThat(tobogganMap.getPatternLength()).isEqualTo(11);
        softly.assertThat(tobogganMap.getTreesPositions()).containsOnlyKeys(1, 2,3);
        softly.assertThat(tobogganMap.getTreesPositions().get(1)).containsExactly(3, 4);
        softly.assertThat(tobogganMap.getTreesPositions().get(2)).isEmpty();
        softly.assertThat(tobogganMap.getTreesPositions().get(3)).containsExactly(1, 11);
    }

}
