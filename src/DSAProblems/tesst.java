package DSAProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class tesst {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        double m= Math.sqrt(x);
        int max=0;
        List<Integer> al=new ArrayList<>();
        for(int i=2;i<x;i++){
            if(x%i==0 && is(i)){
                al.add(i);
                max=Math.max(max,i);
            }
        }
        if (max==m){
            System.out.println("Not Strange");
        }
        else {
            System.out.println("Strange");
        }
    }
   public static boolean is(int i){
        for (int m=2;m<i;m++){
            if (m%i==0){
                return false;
            }
        }
        return true;
    }

}

