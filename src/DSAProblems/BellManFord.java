package DSAProblems;

public class BellManFord {
    class Edge{
        int src,dest,weight;
        Edge(){
            src=dest=weight=0;
        }
    }
    int V,E;
    Edge edge[];
    BellManFord(int v,int e){
        this.V=v;
        this.E=e;
        edge=new Edge[e];
        for (int i=0;i<e;i++){
            edge[i]=new Edge();
        }
    }
    void bf(BellManFord g, int src){
        int V= g.V,E= g.E;
        int[] dist=new int[V];
        for (int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        for (int i=0;i<V-1;i++){
            for (int j=0;j<E;j++){
                 int u=g.edge[j].src;
                 int v= g.edge[j].dest;
                 int weight=g.edge[j].weight;
                 if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v]){
                     dist[v]=dist[u]+weight;
                 }
            }
        }
        for (int j=0;j<E;j++){
            int u=g.edge[j].src;
            int v= g.edge[j].dest;
            int weight=g.edge[j].weight;
            if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v]){
                System.out.println("contains negative weight cycle");
                return;
            }
        }
        for (int i=0;i<V-1;i++){
            System.out.print(dist[i]+" ");
        }
    }

    public static void main(String[] args) {
        int V=5,E=5;
        BellManFord g= new BellManFord(V,E);
        g.edge[0].src=0;
        g.edge[0].dest=1;
        g.edge[0].weight=1;

        g.edge[1].src=1;
        g.edge[1].dest=2;
        g.edge[1].weight=-3;

        g.edge[2].src=0;
        g.edge[2].dest=2;
        g.edge[2].weight=4;

        g.edge[3].src=1;
        g.edge[3].dest=3;
        g.edge[3].weight=2;

        g.edge[4].src=2;
        g.edge[4].dest=3;
        g.edge[4].weight=3;

        g.bf(g,0);


    }
}