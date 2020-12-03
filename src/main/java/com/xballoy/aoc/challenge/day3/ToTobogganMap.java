package com.xballoy.aoc.challenge.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ToTobogganMap implements Function<List<String>, TobogganMap> {

    @Override
    public TobogganMap apply(final List<String> rows) {
        int patternLength = rows.get(0).length();

        Map<Integer, List<Integer>> treesPositions = new HashMap<>();
        for (int i = 0; i < rows.size(); i++) {
            final String row = rows.get(i);
            treesPositions.put(
                i + 1,
                treesInRow(row)
            );
        }

        return new TobogganMap(patternLength, treesPositions);
    }

    private List<Integer> treesInRow(final String row) {
        List<Integer> treePositions = new ArrayList<>();

        final char[] map = row.toCharArray();
        for (int i = 0; i < map.length; i++) {
            if (map[i] == '#') {
                treePositions.add(i + 1);
            }
        }
        return treePositions;
    }
}
