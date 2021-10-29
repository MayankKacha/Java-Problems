import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class contest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int[] ar=new int[n];
        int[] ans=new int[n-k+1];
        for (int i=0;i<n;i++){
            ar[i]= sc.nextInt();
        }
        Queue<Integer> q=new LinkedList<>();
        int i=0;
        while (i<n && i<k){
            if (prime(ar[i])){
                q.add(ar[i]);
            }
            i++;
        }
        int j=0;
        if (!q.isEmpty()){
            ans[j++]=q.peek();
        }  else {
            ans[j++]=0;
        }
        while (i<n){
            if (!q.isEmpty()){
                if (ar[i-k]==q.peek()){
                    q.poll();
                }
            }
            if (prime(ar[i])){
                q.add(ar[i]);
            }
            if (!q.isEmpty()){
                ans[j++]=q.peek();
            } else {
                ans[j++]=0;
            }
            i++;
        }
        for (int m=0;m<n-k+1;m++){
            System.out.print(ans[m]+" ");
        }

    }

    private static boolean prime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}