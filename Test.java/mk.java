import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class mk {
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
            adj[V]=new LinkedList<>();
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<AdjListNode>();
            }
        }
        void addEdge(int u,int v, int weight){
            AdjListNode node=new AdjListNode(v,weight);
            adj[u].add(node);
        }
        void topologicalSort(int v,boolean visited[],Stack<Integer> stack){
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
                if (visited[i]==false) {
                    topologicalSort(i, visited, stack);
                }
            }
            for (int i=0;i<V;i++){
                dist[i]=INF;
            }
            dist[s]=0;
            while(stack.empty()==false){
                int u=(int)stack.pop();
                Iterator<AdjListNode> it=adj[u].iterator()
                if(dist[u]!=INF){
                    while(it.hasNext()){
                        AdjListNode i=it.next();
                        if(dist[i.getV()]>dist[u]+i.getweight()){
                            dist[i.getV()]=dist[u]+i.getweight()
                        }
                    }
                }
            }
            for(int i=0;i<V;i++){
                if(dist[i]==INF){
                    System.out.print("INF ");
                }
                else{
                    System.out.println(dist[i]+" ");
                }
            }
        }

    }
    Graph newGraph(int number){
        return newGraph(number);
    }
    public static void main(String[] args) {
        mk t=new mk();
        Graph g=t.newGraph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        int s=0;
        System.out.println("Shortest distance from s=0 ");
        g.shortestpath(s);

    }
}
