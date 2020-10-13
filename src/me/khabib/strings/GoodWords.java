package me.khabib.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GoodWords {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        chars.chars().map(x -> x - 'a').forEach(x -> count[x]++);

        int ans = 0;
        boolean isGood;
        for (String word : words) {
            int[] word_count = new int[26];
            word.chars().map(x -> x - 'a').forEach(x -> word_count[x]++);
            isGood = IntStream.range(0, 26).noneMatch(i -> count[i] < word_count[i]);
            if (isGood) ans += word.length();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new GoodWords().countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
