package com.xballoy.aoc.challenge.day4;

import com.xballoy.aoc.AdventOfCodeException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum PassportAttribute {
    ECL("ecl", true, new EyeColorValid()),
    PID("pid", true, new PassportIdValid()),
    EYR("eyr", true, new ExpirationYearValid()),
    HCL("hcl", true, new HairColorValid()),
    BYR("byr", true, new BirthYearValid()),
    IYR("iyr", true, new IssueYearValid()),
    CID("cid", false, new CountryIdValid()),
    HGT("hgt", true, new HeightValid());

    private final String key;
    private final boolean required;
    private final Predicate<String> validator;

    PassportAttribute(final String key, final boolean required, final Predicate<String> validator) {
        this.key = key;
        this.required = required;
        this.validator = validator;
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

    public boolean isValid(final String valueForKey) {
        return this.validator.test(valueForKey);
    }
}
