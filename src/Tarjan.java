import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Tarjan {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time;
    Tarjan(int v){
        this.V=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
        time=0;
    }
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    void sccu(int u, int[] low, int[] disc, boolean[] stackmember, Stack<Integer> st){
        disc[u] = time;
        low[u] = time;
        time += 1;
        stackmember[u] = true;
        st.push(u);
        int n;
        Iterator<Integer> i=adj[u].iterator();
        while (i.hasNext()){
            n=i.next();
            if (disc[n]==-1){
                sccu(n,low,disc,stackmember,st);
                low[u]=Math.min(low[u], low[n]);
            }
            else if (stackmember[n]){
                low[u]=Math.min(low[u],disc[n]);
            }
        }
        int w = -1;
        if (low[u] == disc[u])
        {
            while (w != u)
            {
                w = (int)st.pop();
                System.out.print(w + " ");
                stackmember[w] = false;
            }
            System.out.println();
        }
    }
    void scc(){
        int[] disc = new int[V];
        int[] low = new int[V];
        for(int i = 0;i < V; i++)
        {
            disc[i] = -1;
            low[i] = -1;
        }

        boolean[] stackmember = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < V; i++)
        {
            if (disc[i] == -1)
                sccu(i, low, disc, stackmember, st);
        }
    }

    public static void main(String[] args) {
        Tarjan g1=new Tarjan(6);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("SSC in first graph ");
        g1.scc();
    }
}
