package com.xballoy.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapInputToGroup implements Function<List<String>, List<List<String>>> {

    private final String separator;

    public MapInputToGroup() {
        this("");
    }

    public MapInputToGroup(final String separator) {
        this.separator = separator;
    }

    @Override
    public List<List<String>> apply(final List<String> strings) {
        List<Integer> groupSeparatorsIndex =  groupSeparatorsIndex(strings);

        int startIndex = -1;
        final List<List<String>> result = new ArrayList<>();
        for (int i = 0, groupSeparatorsIndexSize = groupSeparatorsIndex.size(); i <= groupSeparatorsIndexSize; i++) {
            int endIndex;
            if(i < groupSeparatorsIndexSize) {
                endIndex= groupSeparatorsIndex.get(i);
            } else {
                endIndex = strings.size();
            }

            result.add(strings.subList(startIndex + 1, endIndex));
            startIndex = endIndex;
        }

        return result;
    }

    private List<Integer> groupSeparatorsIndex(final List<String> strings) {
        return IntStream.range(0, strings.size())
            .filter(i -> separator.equals(strings.get(i)))
            .boxed()
            .collect(Collectors.toList());
    }
}
