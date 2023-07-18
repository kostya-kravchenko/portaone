package org.portaone;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;


public class UniquenessUtils {

    public static String getUniqueChar(String text) {
        return getFirstUnique(Arrays.stream(text.split("[\\s\\p{Punct}]+"))
                .map(UniquenessUtils::getFirstUnique)
                .collect(Collectors.joining()));
    }

    private static String getFirstUnique(String word) {
        return word.chars()
                .mapToObj(Character::toString)
                .filter(ch -> StringUtils.countMatches(word, ch) == 1)
                .findFirst()
                .orElse(StringUtils.EMPTY);
    }
}
