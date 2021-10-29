import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuSCC{
    private int V;
    private LinkedList<Integer> adj[];
    KosarajuSCC(int v){
        this.V=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    void DFS(int v, boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        int n;
        Iterator<Integer> it=adj[v].iterator();
        while (it.hasNext()){
            n= it.next();
            if (!visited[n]){
                DFS(n,visited);
            }
        }
    }
    KosarajuSCC transpos(){
        KosarajuSCC g=new KosarajuSCC(V);
        for (int s=0;s<V;s++){
            Iterator<Integer> i=adj[s].listIterator();
            while (i.hasNext()){
                g.adj[i.next()].add(s);
            }
        }
        return g;
    }
    void fillorder(int s, boolean[] visited, Stack stack){
        visited[s]=true;
        Iterator<Integer> i=adj[s].iterator();
        while (i.hasNext()){
            int n= i.next();
            while (!visited[n]){
                fillorder(n,visited,stack);
            }
        }
        stack.push(new Integer(s));
    }
    void printSCC(){
        Stack stack=new Stack();
        boolean[] visted=new boolean[V];
        for (int i=0;i<V;i++){
            if (!visted[i]){
                fillorder(i,visted,stack);
            }
        }
        KosarajuSCC gr=transpos();
        for (int i=0;i<V;i++) {
            visted[i] = false;
        }
        while (!stack.empty()){
            int n=(int) stack.pop();
            if (!visted[n]){
                gr.DFS(n,visted);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        KosarajuSCC gr=new KosarajuSCC(6);
        gr.addEdge(0,1);
        gr.addEdge(1,2);
        gr.addEdge(2,3);
        gr.addEdge(3,0);
        gr.addEdge(3,4);
        gr.addEdge(4,5);
        gr.addEdge(5,4);
        gr.printSCC();
    }
}