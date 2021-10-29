public class RandomWord {
    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        LinkedList l2=new LinkedList();
        l1.insert(27);
        l1.insert(20);
        l1.insert(24);
        l1.insert(23);
        l1.insert(21);
        l1.show();
        l1.reverse();
    }
}
class Node{
    int data;
    Node next;
}
class LinkedList{
    public Object add;
    Node head;
    public void insert(int data){
        Node node=new Node();
        node.data=data;
        if (head==null) head=node;
        else {
            Node n=head ;
            while (n.next != null) n=n.next;
            n.next=node;
        }
    }
    public void show(){
        Node node=head;
        while (node.next!= null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }
    public void insertAtStart(int data){
        Node node=new Node();
        node.data=data;
        node.next=head;
        head=node;
    }
    public void reverse(){


    }
}