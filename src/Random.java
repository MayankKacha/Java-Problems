import java.util.Arrays;
import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numOfBooks= sc.nextInt();
        int time=sc.nextInt();
        int[] books=new int[numOfBooks];
        for (int i=0;i<numOfBooks;i++){
            books[i]=sc.nextInt();
        }
        int sum=0,count=0,k=0;
        for (int i=0;i<numOfBooks;i++){
            sum+=books[i];
            if (sum<=time){
                count++; }
            else {
                sum=sum-books[k];
                k++;
            }
        }
        System.out.println(count);
    }
}