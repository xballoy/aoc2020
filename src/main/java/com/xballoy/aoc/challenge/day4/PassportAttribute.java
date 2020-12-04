package com.xballoy.aoc.challenge.day4;

import com.xballoy.aoc.AdventOfCodeException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum PassportAttribute {
    ECL("ecl"),
    PID("pid"),
    EYR("eyr"),
    HCL("hcl"),
    BYR("byr"),
    IYR("iyr"),
    CID("cid", false),
    HGT("hgt");

    private final String key;
    private final boolean required;

    PassportAttribute(final String key) {
        this(key, true);
    }

    PassportAttribute(final String key, final boolean required) {
        this.key = key;
        this.required = required;
    }

    public static PassportAttribute fromKey(final String key) {
        return Arrays.stream(values())
            .filter(it -> Objects.equals(it.key, key))
            .findFirst()
            .orElseThrow(() -> new AdventOfCodeException(String.format("The attribute %s does not exist", key)));
    }

    public static List<PassportAttribute> getRequiredAttributes() {
        return Arrays.stream(values())
            .filter(it -> it.required)
            .collect(Collectors.toList());
    }
}
