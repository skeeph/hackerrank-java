package me.khabib.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        List<Character> characters = new ArrayList<>();
        for (char c : T.toCharArray()) {
            if (S.indexOf(c) > -1) {
                characters.add(c);
            }
        }
        characters.sort(Comparator.comparingInt(S::indexOf));
        StringBuilder sb = new StringBuilder();
        int skipped = 0;

        char[] charArray = T.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (S.indexOf(c) > -1) {
                sb.append(characters.get(i - skipped));
            } else {
                sb.append(c);
                skipped++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cba", "abcd"));
    }
}
