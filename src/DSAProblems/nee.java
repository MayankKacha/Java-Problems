package DSAProblems;

import java.util.Arrays;
import java.util.Scanner;

public class nee {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i=0; i<n ; i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        int cost=1;
        int p=a[0];
        for(int i=0;i<n;i++){
            if(a[i]>p+4){
                cost=cost+1;
                p=a[i];
            }
        }
        System.out.println(cost);


    }

    private static int[] partition(int[] arr, int l, int h) {
        int pivot=arr[l];
        int i=l;
        int j=h;
        while (i<=j){
            while (arr[i]< pivot) i++;
            while (arr[j] > pivot) j--;
            if (i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return arr;
    }
    static void partition(int[] ar) {
        int temp=0;
        int pivot=ar[0];
        int pIndex=ar.length-1;
        for(int i=ar.length-1;i>=1;i--){
            if(ar[i]>=pivot){
                temp=ar[i];
                ar[i]=ar[pIndex];
                ar[pIndex]=temp;
                pIndex-=1;
            }
        }
        temp=ar[pIndex];
        ar[pIndex]=ar[0];
        ar[0]=temp;
        printArray(ar);
    }
    static void printArray(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

}