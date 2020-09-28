package me.khabib.sort;

/**
 * https://leetcode.com/problems/shuffle-string/
 */
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] restored = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            restored[indices[i]] = s.charAt(i);
        }
        return String.valueOf(restored);
    }

    public static void main(String[] args) {
        System.out.println(new ShuffleString().restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}
