import javafx.util.Pair;

import java.util.*;

public class RottenOrange {
    public int orangesRotting(int[][] grid){
        int res=0;
        Queue<Pair<Integer,Integer>>queue=new ArrayDeque<>();
        // step 1. build the initial state for rotten oranges
        int freshOranges=0;
        int R=grid.length;
        int C=grid[0].length;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(grid[r][c]==2){
                    queue.offer(new Pair<>(r,c));
                }
                else if(grid[r][c]==1){
                    freshOranges++;
                }
            }
        }
        // Mark the round / level ,i.e the ticker of timestamp
        queue.offer(new Pair<>(-1,-1));
        // step 2:Start the rotating process via BFS
        int minutesElapsed=-1;
        int[][]directions={{-1,0},{0,-1},{1,0},{0,1}};

        while (!queue.isEmpty()){
            Pair<Integer,Integer>p=queue.poll();
            int row=p.getKey();
            int col=p.getValue();

        }


        return  res;
    }

}
