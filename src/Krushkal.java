import java.util.Arrays;

public class Krushkal {
    class Edge implements Comparable<Edge>{
        int src,dest,weight;
        public int compareTo(Edge compare){
            return this.weight - compare.weight;
        }
    };
    class subset{
        int parent,rank;
    }
    int V,E;
    Edge[] edge;
    Krushkal(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge() ;
    }
    int find(subset subset[], int i){
        if (subset[i].parent != i)
            subset[i].parent
                    = find(subset, subset[i].parent);

        return subset[i].parent;
    }
    void Union(subset[] subsets,int x,int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void KrushkalMST(){
        Edge res[]=new Edge[V];
        int e=0;
        int i = 0;
        for (i = 0; i < V; ++i)
            res[i] = new Edge();
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i=0;
        while (e< V-1){
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                res[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        int minimumCost=0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(res[i].src + " -- "
                    + res[i].dest
                    + " == " + res[i].weight);
            minimumCost += res[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
    }

    public static void main(String[] args) {
        int V=4;
        int E=5;
        Krushkal graph=new Krushkal(V,E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KrushkalMST();
    }
}
