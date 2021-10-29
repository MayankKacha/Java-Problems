import java.util.Iterator;
import java.util.LinkedList;

public class Bridges {
    private int V;
    private LinkedList<Integer> adj[];
    int time=0;
    static final int NIL=-1;
    Bridges(int v){
        this.V=v;
        adj=new LinkedList[v];
        for (int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    void bu(int u, boolean[] visited,int[] disc, int[] low, int[] parent){
        visited[u]=true;
        disc[u]=low[u]=++time;
        Iterator<Integer> i=adj[u].iterator();
        while (i.hasNext()){
            int v=i.next();
            if (!visited[v]){
                parent[v]=u;
                bu(v,visited,disc,low,parent);
                low[u]=Math.min(low[u],low[v]);
                if (low[v]>disc[u]){
                    System.out.println(u+" "+v);
                }
            }
            else if (v!=parent[u]){
                low[u]=Math.min(low[u],disc[v]) ;
            }
        }
    }
    void bridge(){
        boolean[] visited=new boolean[V];
        int[] low=new int[V];
        int[] disc=new int[V];
        int[] parent=new int[V];
        for (int i = 0; i < V; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
        }
        for (int i=0;i<V;i++){
            if (!visited[i]){
                bu(i,visited,disc,low,parent);
            }
        }
    }

    public static void main(String[] args) {
        Bridges g1=new Bridges(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();
    }

}
