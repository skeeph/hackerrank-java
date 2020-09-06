package me.khabib.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckPalindrome {
    public static boolean isPalindromePermutation(String s){

        Map<Character, Long> counts = s.toLowerCase().chars()
                .filter(x->Character.isAlphabetic(x)||Character.isDigit(x)).
                        mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long odd = counts.values().stream().filter(x -> x % 2 == 1).count();
        return odd<=1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
}
