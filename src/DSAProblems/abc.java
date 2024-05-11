package DSAProblems;

import java.util.*;

public class abc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> d=new ArrayList<>();
        List<String> q=new ArrayList<>();
        int nd= sc.nextInt();
        while (nd--!=0){
            d.add(sc.next());
        }
        int nq= sc.nextInt();
        while (nq--!=0){
            q.add(sc.next());
        }
        List<Integer> ans=stringAnagram(d,q);
        System.out.println(ans);

    }
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<String> d=ne(dictionary);
        List<String> q=ne(query);
        List<Integer> ans=new ArrayList<>();
        for (int i=0;i<q.size();i++){
            ans.add(Collections.frequency(d,q.get(i)));
        }
        return ans;
    }
    public static List<String> ne(List<String> s){
        List<String> d=new ArrayList<>();
        for(int i=0;i<s.size();i++){
            String s1=s.get(i);
            char[] c=s1.toCharArray();
            Arrays.sort(c);
            String s2=String.valueOf(c);
            d.add(s2);
        }
        return d;

    }
}
