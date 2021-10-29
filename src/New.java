import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]= sc.nextInt();
        }
        quicksort(a,0,n-1);

    }
    public static void quicksort(int[] a, int l, int h){
        if (l<h){
            int pivot=partition ( a, l,h);
            quicksort(a, l, pivot-1);
            quicksort(a , pivot+1, l);
            print(a,l,h);
        }
    }

    private static void print(int[] a, int l, int h) {
        for (int i=l;i<=h;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }

    private static int partition(int[] a, int l, int h) {
        int i=l;
        int pivot=a[l];
        List<Integer> left=new ArrayList<>();
        List<Integer> right =new ArrayList<>();
        for (int j=l+1; j<= h; j++){
            if (a[j] < pivot) {
                left.add(a[j]);
            }else {
                right.add(a[j]);
            }
        }
        for (int n:
             left) {
            a[i++]=n;
        }
        a[i++]= pivot;
        for (int n:
                right) {
            a[i++]=n;
        }
        return l+left.size();
    }
}
