package me.khabib.strings;

/**
 * https://leetcode.com/problems/rotate-string/
 */
public class RotateStrings {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length()<2) return true;
        int shiftSize = 0;
        while (shiftSize < A.length()) {
            boolean differ = false;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt((i + shiftSize) % B.length())) {
                    differ = true;
                    break;
                }
            }
            if (!differ) return true;
            shiftSize++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RotateStrings().rotateString("abcde", "abced"));
    }
}
