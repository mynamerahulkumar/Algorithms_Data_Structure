import java.util.Iterator;
import java.util.LinkedList;

public class CycleDFS {
   static class Graph{
        private  int V; // no of vertices
        private LinkedList<Integer>adj[];
        Graph(int v){
            this.V=v;
            adj=new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<>();
            }
        }
        void addEdge(int u,int v){
            adj[u].add(v);
        }
        boolean isCyclicDFSUtil(int v,boolean[]visited,boolean[]path){
            // mark the current node as visited
            System.out.println(v);
            if(path[v]) return  true;
            if(visited[v]) return  false; // means this node has been already searched so return false since there was no cycle
            visited[v]=true;
            path[v]=true;
            // recur for all the adjacent vertices to this vertex
            Iterator<Integer> i=adj[v].iterator();
            while(i.hasNext()){
                int n=i.next();
                if(isCyclicDFSUtil(n,visited,path))
                {
                    return true;
                }
            }
            path[v]=false;// since from the vertex v there was no cycle we mark them uncylic not counted in path
            return false;
        }
        boolean DFS(){
            boolean[]visited=new boolean[V];
            boolean[]path=new boolean[V];
            for(int i=0;i<V;i++){
                if(isCyclicDFSUtil(i,visited,path)){
                    return true;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.DFS())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");


    }
}
