package me.khabib.strings;

public class Compress {
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (prev == c)
                count++;
            else {
                sb.append(prev).append(count);
                count = 1;
                prev = c;
            }
        }
        sb.append(prev).append(count);
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}
