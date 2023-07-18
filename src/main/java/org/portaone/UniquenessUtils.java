package org.portaone;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class UniquenessUtils {

    public static String getUniqueChar(String text) {
//        String[] split = text.split("[\\s\\p{Punct}]+");
//        return getFirstUnique(Pattern.compile("[\\w'.+]+")
//                .matcher(text)
//                .results()
//                .map(MatchResult::group)
//                .map(UniquenessUtils::getFirstUnique)
//                .collect(Collectors.joining()));

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
