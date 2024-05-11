package DSAProblems;

import java.util.Scanner;

public class Trt {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- != 0){
            int n= sc. nextInt();
            String s[][] = new String[n][n];
            int[][] m = new int[n][n];
            int[][] unity = new int[n][n];
            int[][] ans = new int[n][n];
            StringBuffer sb= new StringBuffer();
            for (int i=0;i<n;i++){
               String s1= sc.next();
                sb.append(s1);
               for (int j=0;j<s1.length();j++){
                   m[i][j]= s1.charAt(j);
                   unity[i][j]=1;
               }
            }

//            System.out.println(sb.toString());
//            System.out.println(sb.reverse().toString());
            String s1= sb.toString();
            String s2= sb.reverse().toString();
//            if ((s1==s2)){
//                System.out.println("YES");
//            }else {
//                System.out.println("NO");
//            }
            if (s1.equals(s2)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }



        }
    }
    static void multiply(int[][] a , int[][] b ,int[][] c){
        int n= a.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                c[i][j]=0;
                for (int k=0;k<n;k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }

    }
}