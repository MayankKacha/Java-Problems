import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathDAG {
    static final int INF= Integer.MAX_VALUE;
    class AdjListNode{
        private int V;
        private int weight;
        AdjListNode(int _v,int _w){
            this.V=_v;
            this.weight=_w;
        }
        int getV(){
            return V;
        }
        int getweight(){
            return weight;
        }
    }
    class Graph{
        private int V;
        public LinkedList<AdjListNode> adj[];
        Graph(int v){
            V=v;
            adj=new LinkedList[V];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<AdjListNode>();
            }
        }
        void addEdge(int u,int v, int weight){
            AdjListNode node=new AdjListNode(v,weight);
            adj[u].add(node);
        }
        @SuppressWarnings("removal")
        void topologicalSort(int v, boolean visited[], Stack<Integer> stack){
            visited[v]=true;
            Integer i;
            Iterator<AdjListNode> it=adj[v].iterator();
            while(it.hasNext()){
                AdjListNode node=it.next();
                if (!visited[node.getV()]) {
                    topologicalSort(node.getV(), visited, stack);
                }
            }
            stack.push(new Integer(v));

        }
        void shortestpath(int s){
            Stack<Integer> stack=new Stack<>();
            int[] dist=new int[V];
            boolean visited[]=new boolean[V];
            for(int i=0;i<V;i++){
                if (!visited[i]) {
                    topologicalSort(i, visited, stack);
                }
            }
            for (int i=0;i<V;i++){
                dist[i]=INF;
            }
            dist[s]=0;
            while(!stack.empty()){
                int u=(int)stack.pop();
                Iterator<AdjListNode> it=adj[u].iterator();
                if(dist[u]!=INF){
                    while(it.hasNext()){
                        AdjListNode i=it.next();
                        if(dist[i.getV()]>dist[u]+i.getweight()){
                            dist[i.getV()]=dist[u]+i.getweight();
                        }
                    }
                }
            }
            for(int i=0;i<V;i++){
                if(dist[i]==INF){
                    System.out.print("INF ");
                }
                else{
                    System.out.print(dist[i]+" ");
                }
            }
        }

    }
    Graph newGraph(int number){
        return new Graph(number);
    }
    public static void main(String[] args) {
        ShortestPathDAG t=new ShortestPathDAG();
        Graph g=t.newGraph(4);
        g.addEdge(0,1,1);
        g.addEdge(1,2,3);
        g.addEdge(1,3,2);
        g.addEdge(2,3,4);
        int s=1;
        System.out.println("Shortest distance from s=0 ");
        g.shortestpath(s);

    }
}
