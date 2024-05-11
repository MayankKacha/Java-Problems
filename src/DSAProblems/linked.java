package DSAProblems;

import java.util.Scanner;

public class linked {
    static solution.Node head;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int n= sc.nextInt();
        solution.Linkedlist l1=new solution.Linkedlist();
        for (int i=0;i<n;i++){
            l1.insert(sc.nextInt());
        }
        int in= sc.nextInt();

        solution.Linkedlist.print();
    }
    public static class solution {

        public static class Node {
            int data;
            Node next;
        }

        public static class Linkedlist {

           static Node head;

            public void insert(int data) {
                Node node = new Node();
                node.data = data;
                if (head == null) {
                    head = node;
                } else {
                    Node n = head;
                    while (n.next != null) {
                        n = n.next;
                    }
                    n.next = node;
                }
            }
            public static void delete(int index){
                if (index==0)
                    head=head.next;
                else {
                    Node n=head;
                    for (int i=0;i<index-1;i++){
                        n=n.next;
                    }
                    Node n1=null;
                    n1=n.next;
                    n.next=n1.next;
                }
            }

            public static void print() {
                Node tn=head;
                while (tn.next != null) {
                    System.out.println(tn.data);
                    tn = tn.next;
                }
                System.out.println(tn.data);
            }

            public static Node Merge(Node h1, Node h2) {
                if (h1 == null) {
                    return h2;
                } else if (h2 == null) {
                    return h1;
                } else if (h1.data <= h2.data) {
                    h1.next = Merge(h1.next, h2);
                    return h1;
                } else {
                    h2.next = Merge(h1, h2.next);
                    return h2;
                }
            }
            public static Node swap(Node head){
                Node temp=head;
                while (temp!=null && temp.next!=null){
                    int k=temp.next.data;
                    temp.next.data= temp.data;
                    temp.data= k;
                    temp= temp.next.next;
                }
                return head;
            }
            public static Node reverse(Node h){
                if (h==null || h.next==null){
                    return h;
                }
                Node ne=reverse(h.next);
                h.next.next=h;
                h.next=null;
               return ne;
            }

        }
    }
}