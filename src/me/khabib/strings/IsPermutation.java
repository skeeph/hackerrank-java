package me.khabib.strings;

import java.util.HashMap;
import java.util.Map;

public class IsPermutation {
    public static boolean isPermutation(String s1, String s2) {
        Map<Character, Integer> counts = new HashMap<>();
        s1.chars().mapToObj(x->(char)x).forEach(c->{
            counts.putIfAbsent(c,0);
            counts.computeIfPresent(c, (character, integer) -> integer+1);
        });

        s2.chars().mapToObj(x->(char)x).forEach(c-> counts.computeIfPresent(c, (character, integer) -> integer-1));


        for (Integer value : counts.values()) {
            if (value != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "bca"));
    }
}
