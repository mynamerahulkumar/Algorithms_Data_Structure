package geekForGeeks.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

/*
Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree
 The only catch here is, unlike trees, graphs may contain cycles,
  so we may come to the same node again. To avoid processing a node more than once,
   we use a boolean visited array. For simplicity, it is assumed that all vertices are
    reachable from the starting vertex.

For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0,
 we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices,
 then 2 will be processed again and it will become a non-terminating process.
 A Breadth First Traversal of the following graph is 2, 0, 3, 1.
 */
public class BFS {
    private int V;//No of vertices
    private LinkedList<Integer> adj[];
    BFS(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    void BFS_traversal(int s){
        // mark all the visited element as false
        boolean[]visited=new boolean[V];
        //create a queue for BFS
        LinkedList<Integer>queue=new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while (!queue.isEmpty()){
            s=queue.poll();
            System.out.println(s+" ");
            // iterate over all the adjacent element
            Iterator<Integer>it=adj[s].listIterator();
            while (it.hasNext()){
                int n=it.next();
                if(visited[n]==false){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs=new BFS(4);
        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(2,0);
        bfs.addEdge(2,3);
        bfs.addEdge(1,2);
        bfs.addEdge(3,3);
        System.out.println("BFS traversal");
        bfs.BFS_traversal(2);
    }

}
