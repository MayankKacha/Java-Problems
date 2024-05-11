package DSAProblems;

import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("insert");
        int insert=sc.nextInt();
        Node root=null;
        while (insert--!=0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        System.out.println("search");
        int s=sc.nextInt();
        boolean ne;
        ne= search(root,s);
        System.out.println("is there ? " +ne);
        System.out.println("delete");
        int d=sc.nextInt();
        delNode(root,d);
        inorder(root);

    }
    static class Node{
        int key;
        Node left,right;
        Node(int x){
            this.key=x;
        }
    }
    static Node insert(Node root, int x){
        if(root==null){
            return new Node(x);
        }
        if (root.key>x){
            root.left=insert(root.left,x);
        }
        else if (root.key<x){
            root.right=insert(root.right,x);
        }
        return root;
    }
    static boolean search(Node root, int x){
        if (root==null){
            return false;
        }
        else if (root.key==x)
            return true;
        else if (root.key>x)
            return search(root.left,x);
        else
            return search(root.right,x);
    }
    static Node delNode(Node root, int x){
        if (root==null)
            return null;
        if (root.key>x)
            root.left=delNode(root.left,x);
        else if (root.key<x){
            root.right=delNode(root.right,x);
        }
        else {
            if (root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;
            else {
                Node succ=getsucc(root);
                root.key= succ.key;
                root.right=delNode(root.right,succ.key);
            }
        }
        return root;
    }
    static Node getsucc(Node root){
        Node curr=root.right;
        while (curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }
    static void inorder(Node root){
        if (root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }

}

