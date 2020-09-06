package me.khabib.strings;

public class URLify {

    public static char[] replaceSpaces(char[] s){
        int spaces = 0;
        for (char c : s) {
            if (c==' ') spaces++;
        }

        char[] result = new char[s.length+2*spaces];
        for (int i = 0; i < result.length; i++) {
            if (s[i]==' '){
                result[i]='%';
                result[i+1]='2';
                result[i+2]='0';
                i=i+1;
            }else {
                result[i]=s[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith".toCharArray()));
    }
}
