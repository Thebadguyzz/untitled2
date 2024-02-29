package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class

public class VietnameseLetterCounter {

    public static int countVietnameseLetters(String input) {
        String[] vietnamesePatterns = {"aw", "aa", "dd", "ee", "oo", "ow", "w"};
        Map<String, Integer> patternCount = new HashMap<>();

        for (String pattern : vietnamesePatterns) {
            patternCount.put(pattern, 0);
        }

        for (String pattern : vietnamesePatterns) {
            int index = 0;
            while ((index = input.indexOf(pattern, index)) != -1) {
                patternCount.put(pattern, patternCount.get(pattern) + 1);
                index += pattern.length();
            }
        }

        int correctedWCount = Math.max(0, patternCount.get("w") - patternCount.get("aw") - patternCount.get("ow"));
        return patternCount.values().stream().mapToInt(Integer::intValue).sum() - patternCount.get("w") + correctedWCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter a string: ");

        String inputStr = scanner.nextLine(); // Read user input
        int result = countVietnameseLetters(inputStr);

        System.out.println("Number of Vietnamese letters: " + result);
        scanner.close(); // Close the scanner
    }
}
