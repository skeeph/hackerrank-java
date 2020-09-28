package me.khabib.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 */
public class RearrangeText {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(new RearrangeText().arrangeWords("Leetcode is cool"));
    }
}
