package me.khabib.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    Map<Character, Integer> dict = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char prev = s.charAt(0);
        int result = dict.get(prev);
        for (int i = 1; i < s.toCharArray().length; i++) {
            if (dict.get(prev) >= dict.get(s.charAt(i))) {
                result += dict.get(s.charAt(i));
                prev = s.charAt(i);
            } else {
                result -= dict.get(prev);
                result += dict.get(s.charAt(i)) - dict.get(prev);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }
}
