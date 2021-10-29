
import java.util.*;

public class HelloGoodbye {

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String q[]=new String[n];
        for(int i=0;i<n;i++)
        {
            q[i]=sc.nextLine();

        }
        getmax(q);

    }

    public static void getmax(String q[])
    {
        Stack <Integer> temp=new Stack();
        Stack<Integer> max=new Stack<>();
        max.push(0);
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<q.length;i++)
        {
            if(q[i].charAt(0)=='1')
            {
                temp.push(Integer.parseInt(q[i].substring(2)));
                int m= temp.peek();
                int n= max.peek();
                if (m > n ){
                    max.push(m);
                }else {
                    max.push(n);
                }

            }
            else if(q[i].charAt(0)=='2')
            {
                temp.pop();
                max.pop();

            }
            else
            {
                System.out.println(max.peek());

            }



        }
//        for(int i=0;i<arr.size();i++)
//        {
//            System.out.println(arr.get(i));
//        }

    }

}