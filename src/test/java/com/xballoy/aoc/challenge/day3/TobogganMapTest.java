package com.xballoy.aoc.challenge.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TobogganMapTest {

    @ParameterizedTest
    @ValueSource(ints = {
        4,
        15,
        26
    })
    void isTreeAtPosition_shouldConsiderMapInfinite(final int x) {
        // Arrange
        // Suppose the following input ...#.......
        final Map<Integer, List<Integer>> treesPositions = new HashMap<>();
        treesPositions.put(1, Arrays.asList(4));

        final TobogganMap cut = new TobogganMap(
            11,
            treesPositions
        );

        // Act
        final boolean hasTree = cut.isTreeAtPosition(1, x);

        // Assert
        assertThat(hasTree).isTrue();
    }

    @Test
    void foo() {
        // Arrange
        // Suppose the following input ..........#
        final Map<Integer, List<Integer>> treesPositions = new HashMap<>();
        treesPositions.put(1, Arrays.asList(11));

        final TobogganMap cut = new TobogganMap(
            11,
            treesPositions
        );

        // Act
        final boolean hasTree = cut.isTreeAtPosition(1, 11);

        // Assert
        assertThat(hasTree).isTrue();
    }

    @Test
    void rows_shouldReturnNumberOfRowsToSlide() {
        // Suppose the following input ...........
        //                             ...........
        //                             ...........
        final Map<Integer, List<Integer>> treesPositions = new HashMap<>();
        treesPositions.put(1, new ArrayList<>());
        treesPositions.put(2, new ArrayList<>());
        treesPositions.put(3, new ArrayList<>());

        final TobogganMap cut = new TobogganMap(
            11,
            treesPositions
        );

        // Act
        final int rows = cut.rows();

        // Assert
        assertThat(rows).isEqualTo(3);
    }
}
