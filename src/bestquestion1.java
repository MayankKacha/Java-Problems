


import java.util.Scanner;

public class bestquestion1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of cabinets ");
        int numOfCabinets= sc.nextInt();
        System.out.println("Enter number of workers ");
        int numOfWorkers=sc.nextInt();
        int[] arr=new int[numOfCabinets];
        System.out.println("Type cabinets ");
        for (int i=0;i<numOfCabinets;i++){
            arr[i]= sc.nextInt();
        }
        int ans= workload(arr, numOfWorkers);
        System.out.println("Minimum value of maximum number of cabinets is "   +ans);
    }
    public static int max(int[] a){
        int max=0;
        for (int i=0;i<a.length;i++) {
            if (a[i] > max){
                max=a[i];
            }
        }
        return max;
    }
    public static int sum(int[] a){
        int sum=0;
        for (int i=0; i <a.length; i++){
            sum+=a[i];
        }
        return sum;
    }
    public static int workload(int[] a, int workers){
        int min=max(a);
        int max=sum(a);
        int load=0;
        while (min<= max){
            int mid= (min+max)/2;
            if (canWeAssign(a,workers,mid)){
                load=mid;
                max=mid-1;
            }
            else {
                min=mid+1;
            }
        }
        return load;
    }
    public static boolean canWeAssign(int[] a, int workers, int load){
        int worker=1;
        int sum=0;
        for (int i=0;i<a.length;i++){
            if (sum+ a[i] > load){
                worker++;
                sum=a[i];
            }
            else {
                sum+=a[i];
            }
        }
        return worker<=workers;
    }
}