package com.xballoy.aoc.challenge.day3;

import java.util.List;
import java.util.Map;

public class TobogganMap {

    private final int patternLength;
    private final Map<Integer, List<Integer>> treesPositions;

    public TobogganMap(final int patternLength,
                       final Map<Integer, List<Integer>> treesPositions) {
        this.patternLength = patternLength;
        this.treesPositions = treesPositions;
    }

    public boolean isTreeAtPosition(final int y, final int x) {
        final List<Integer> treePositionAtY = treesPositions.get(y);
        int position = x % patternLength == 0 ? patternLength : x % patternLength;
        return treePositionAtY.contains(position);
    }

    public int rows() {
        return treesPositions.size();
    }

    protected int getPatternLength() {
        return this.patternLength;
    }

    protected Map<Integer, List<Integer>> getTreesPositions() {
        return this.treesPositions;
    }
}
