package me.khabib.strings;

public class AllCharsUnique {
    public static boolean allCharsUnique(String s){
        int x=0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            int position = 1<<c;
            if ((x&position)>0) return false;
            x |= position;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allCharsUnique("abcb"));
    }
}
