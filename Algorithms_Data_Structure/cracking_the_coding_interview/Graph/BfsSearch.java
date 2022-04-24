import java.util.Iterator;
import java.util.LinkedList;

public class BfsSearch {
    static class Graph{
        private int V;// No of vertices
        private LinkedList<Integer>adj[]; // adjacency list
        Graph(int v){
            V=v;
            adj=new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<>();
            }
        }
        // function to add edge in a graph
        void addEdge(int v,int w){
            adj[v].add(w);
        }
        // print BFS traversal from a given source
        boolean  isReachable(int s,int d){
            LinkedList<Integer> temp;
            // mark initially all the vertice non visited
            boolean [] visited=new boolean[V];
            //Create a queue for BFS
            LinkedList<Integer>queue=new LinkedList<Integer>();
            // mark the current node visisted and enqueue it
            visited[s]=true;
            queue.add(s);
            // 'i' will be used to get all adjacent vertices of a vertex
            Iterator<Integer>i;
            while (queue.size()!=0){
                //Dequee a vertex and print it
                s=queue.poll();
                int n;
                i=adj[s].listIterator();
                // get all the adjacent element of dequeue vertex
                // if a adjacent has not been visited ,then mark it
                //visited and enqueue it
                while(i.hasNext()){
                    n=i.next();
                    if(n==d){
                        return true;
                    }
                    if(!visited[n]){
                        visited[n]=true;
                        queue.add(n);
                    }
                }
            }
            return false;
        }


    }
    public static void main(String[] args) {
        Graph g=new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

    }


}
