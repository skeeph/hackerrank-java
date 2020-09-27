package me.khabib.strings;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        Map<Integer, Long> sChars = s.chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<Integer, Long> tChars = t.chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        return sChars.equals(tChars);
    }

    public static void main(String[] args){
      System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }
}
