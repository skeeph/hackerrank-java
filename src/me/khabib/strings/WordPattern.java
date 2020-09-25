package me.khabib.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int[] pattern_encoded = new int[pattern.length()];
        int k = 0;
        Map<Character, Integer> patternIds = new HashMap<>();
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!patternIds.containsKey(c)) {
                patternIds.put(c, k);
                k++;
            }
            pattern_encoded[i] = patternIds.get(c);
        }

        String[] words = s.split(" ");
        int[] str_encoded = new int[words.length];
        k=0;
        Map<String, Integer> stringIds = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!stringIds.containsKey(word)) {
                stringIds.put(word, k);
                k++;
            }
            str_encoded[i] = stringIds.get(word);
        }

        return Arrays.equals(pattern_encoded, str_encoded);
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}
