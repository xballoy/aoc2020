package com.xballoy.aoc.challenge;

import com.xballoy.aoc.InputSupplier;
import com.xballoy.aoc.challenge.day4.PassportAttribute;
import com.xballoy.aoc.challenge.day4.ToPassportData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day4 {

    private final List<Map<PassportAttribute, String>> passportsData;

    public Day4(InputSupplier inputSupplier) {
        this.passportsData = new ToPassportData()
            .apply(inputSupplier.get().collect(Collectors.toList()));
    }

    public int part1_validPassport() {
        int validPassportCount = 0;

        for (Map<PassportAttribute, String> passport: passportsData) {
            final boolean containsRequiredAttributes = passport.keySet()
                .containsAll(PassportAttribute.getRequiredAttributes());

            if(containsRequiredAttributes) {
                validPassportCount += 1;
            }
        }

        return validPassportCount;
    }

    public int part2_validPassport() {
        int validPassportCount = 0;

        for (Map<PassportAttribute, String> passport: passportsData) {
            final boolean isValid = Arrays.stream(PassportAttribute.values())
                .allMatch(attribute -> {
                    final String valueForKey = passport.get(attribute);
                    return attribute.isValid(valueForKey);
                });

            if(isValid) {
                validPassportCount += 1;
            }
        }

        return validPassportCount;
    }
}
