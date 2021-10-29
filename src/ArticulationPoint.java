import java.util.ArrayList;

public class ArticulationPoint {
    static int time;
    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u, int v ){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void AP(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, int[] disc, int[] low, int parent, boolean[] isAp){
        int children=0;
        visited[u]=true;
        disc[u]=low[u]=++time;
        for (Integer v: adj.get(u)){
            if (!visited[v]){
                children++;
                AP(adj,v,visited,disc,low,u,isAp);
                low[u]=Math.min(low[u],low[v]);
                if (parent!=-1 && low[v]>=disc[u]){
                    isAp[u]=true;
                }
            }
            else if (v!=parent){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (parent == -1 && children > 1){
            isAp[u]=true;
        }
    }
    static void App(ArrayList<ArrayList<Integer> > adj, int V){
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        int time = 0, par = -1;
        for (int u = 0; u < V; u++)
            if (!visited[u])
                AP(adj, u, visited, disc, low, par, isAP);

        for (int u = 0; u < V; u++)
            if (isAP[u])
                System.out.print(u + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj1 =
                new ArrayList<ArrayList<Integer> >(V);
        for (int i = 0; i < V; i++)
            adj1.add(new ArrayList<Integer>());
        addEdge(adj1, 1, 0);
        addEdge(adj1, 0, 2);
        addEdge(adj1, 2, 1);
        addEdge(adj1, 0, 3);
        addEdge(adj1, 3, 4);
        System.out.println("Articulation points in first graph");
        App(adj1, V);
    }

}
