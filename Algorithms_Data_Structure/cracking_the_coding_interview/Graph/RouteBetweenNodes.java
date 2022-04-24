import java.util.LinkedList;

public class RouteBetweenNodes {
    private  int V;// number of vertices
    private LinkedList<Integer> adj[];// adjacency list
   public RouteBetweenNodes(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int s,int d){
       adj[s].add(d);
    }
    //bfs approach
    /*
    Algorithm:

1.The implementation below is using BFS.
2.Create a queue and a visited array initially filled with 0, of size V where V is number of vertices.
3.Insert the starting node in the queue, i.e. push u in the queue and mark u as visited.
4.Run a loop until the queue is not empty.
5.Dequeue the front element of the queue. Iterate all its adjacent elements.
If any of the adjacent element is the destination return true. Push all the adjacent and unvisited vertices in the queue and mark them as visited.
6.Return false as the destination is not reached in BFS.
     */
    Boolean isReachable(int s,int d){
        LinkedList<Integer>temp;
        //create queue for bfs
        LinkedList<Integer>queue=new LinkedList<>();
        boolean[]isVisited=new boolean[V];
        queue.add(s);
        isVisited[s]=true;
        while (!queue.isEmpty()){
            int p=queue.poll();
            temp=adj[p];
            while (!temp.isEmpty()){
                int q=temp.pop();
                if(q==d){
                    return true;
                }
                else{
                    if(!isVisited[q]){
                        queue.add(q);
                        isVisited[q]=true;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        RouteBetweenNodes graph=new RouteBetweenNodes(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        int u=1;
        int v=3;
        if (graph.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

        u = 3;
        v = 1;
        if (graph.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }

}
