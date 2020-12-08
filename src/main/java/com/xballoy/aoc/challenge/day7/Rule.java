package com.xballoy.aoc.challenge.day7;

import java.util.Map;

public class Rule {

    private final String bagType;
    private final Map<String, Integer> content;

    public Rule(final String bagType, final Map<String, Integer> content) {
        this.bagType = bagType;
        this.content = content;
    }

    public String getBagType() {
        return this.bagType;
    }

    public Map<String, Integer> getContent() {
        return this.content;
    }
}
