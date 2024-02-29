package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int countVietnameseLetters(String input) {
        // Define the patterns for Vietnamese characters in Telex typing
        String[] vietnamesePatterns = {"aw", "aa", "dd", "ee", "oo", "ow", "w"};
        Map<String, Integer> patternCount = new HashMap<>();

        // Initialize the count for each pattern
        for (String pattern : vietnamesePatterns) {
            patternCount.put(pattern, 0);
        }

        // Count occurrences of each pattern
        for (String pattern : vietnamesePatterns) {
            int index = 0;
            while ((index = input.indexOf(pattern, index)) != -1) {
                patternCount.put(pattern, patternCount.get(pattern) + 1);
                index += pattern.length();
            }
        }

        // Correct the count for 'w' to avoid counting it in 'aw' and 'ow'
        int correctedWCount = Math.max(0, patternCount.get("w") - patternCount.get("aw") - patternCount.get("ow"));
        return patternCount.values().stream().mapToInt(Integer::intValue).sum() - patternCount.get("w") + correctedWCount;
    }

    public static void main(String[] args) {
        String inputStr = "hfdawhwhcoomdd";
        int result = countVietnameseLetters(inputStr);
        System.out.println("Number of Vietnamese letters: " + result);
        // a
    }
}