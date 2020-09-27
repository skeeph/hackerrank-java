package me.khabib.strings;

/**
 * https://leetcode.com/problems/reverse-string
 */
public class ReverseStrings {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char k = s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1] = k;
        }
    }

    public static void main(String[] args) {
        char[] s = "hу".toCharArray();
        new ReverseStrings().reverseString(s);
        System.out.println(s);
    }
}
