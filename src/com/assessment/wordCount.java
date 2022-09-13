package com.assessment;

import java.util.*;

public class wordCount {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Input a string of words to be counted.");
        } else {
            // Split our given words into a list
            List<String> wordList = Arrays.asList(args[0].toLowerCase().split(" "));

            // Throw all of our words into a hash map
            Map<String, Integer> countedWords = countWords(wordList);

            // Sort the hash map by value, descending
            countedWords = sortWords(countedWords);

            // Print out our result
            for (String word : countedWords.keySet()) {
                System.out.println(countedWords.get(word) + "\t" + word);
            }
        }
    }

    private static Map<String, Integer> countWords(List<String> wordList) {
        Map<String, Integer> countedWords = new HashMap<>();
        for (String word : wordList) {
            Integer count = 1;
            if (countedWords.containsKey(word)) {
                count = countedWords.get(word);
                count += 1;
            }

            countedWords.put(word, count);
        }

        return countedWords;
    }

    private static Map<String, Integer> sortWords(Map<String, Integer> countedWords) {
        Map<String, Integer> sortedWords = new LinkedHashMap<>();
        // Sort by value, descending
        countedWords.entrySet().stream().sorted(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        })).forEachOrdered(entry -> sortedWords.put(entry.getKey(), entry.getValue()));

        return sortedWords;
    }
}
