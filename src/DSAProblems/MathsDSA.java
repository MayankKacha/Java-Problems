package DSAProblems;

import java.util.Arrays;

public class MathsDSA {

    public static void main(String[] args) {

        System.out.println(posOfRightMostDiffBit(11,6));
    }

    private static boolean checkKthBit(int n,int k){
        n = n >> (k-1);
        return (n&1) != 0;
    }

    public static int posOfRightMostDiffBit(int m, int n)
    {

        // Your code here
        if(m==n) return -1;
        int res = 0;
        while(m>0 && n>0){
            if((m^n) == 1){
                return res+1;
            }
            res++;
            m /= 2; n/=2;
        }
        return (m==n )? -1 : res;
    }

}
