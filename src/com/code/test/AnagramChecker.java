package com.code.test;

import java.util.*;

public class AnagramChecker {
    public static boolean isAnagram(String word1, String word2) throws InvalidInputException {

        if (word1.isBlank() || word2.isBlank()) {
            throw new InvalidInputException("Both words must be non-null");
        }

        if (word1.length() != word2.length()) {
            return false;
        }

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        Map<Character, Integer> frequencyMap = new HashMap<>();

        //Generate the Frequency HashMap form the first word for Each letters
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        //Compare the first word and second word base on these character frequency
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            if (!frequencyMap.containsKey(c) || frequencyMap.get(c) == 0) {
                return false;
            }
            frequencyMap.put(c, frequencyMap.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first word: ");
        String word1 = scanner.nextLine();
        System.out.print("Enter the second word: ");
        String word2 = scanner.nextLine();

        try {
            if (isAnagram(word1, word2)) {
                System.out.println(word1 + " and " + word2 + " are anagrams!");
            } else {
                System.out.println(word1 + " and " + word2 + " are not anagrams.");
            }
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}



