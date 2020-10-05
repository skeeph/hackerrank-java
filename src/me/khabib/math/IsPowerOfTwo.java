package me.khabib.math;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return Integer.bitCount(n)==1;
    }

    public static void main(String[] args){
      System.out.println(new IsPowerOfTwo().isPowerOfTwo(3));
      System.out.println(new IsPowerOfTwo().isPowerOfTwo(16));
    }
}
