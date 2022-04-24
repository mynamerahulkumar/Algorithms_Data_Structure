import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Climbing_the_leaderBoard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        // your code goes here
        int[]rank=new int[n];
        int r=1;
         rank[0]=1;
        for(int i=1;i<n;i++){
            if(scores[i]==scores[i-1]){
                rank[i]=r;
            }
            else{
                rank[i]=++r;
            }
        }
        int sum=0;
        int j=n-1;
        int fnd=0;
        for(int i=0;i<m;i++){
            sum=alice[i];   
            while(j>=0&&fnd==0&&sum>=scores[j]){
                  if(j==0){                     
                      fnd=1;
                      break;
                  }
                j--;
            }
            if(j!=0)
            System.out.println(rank[j]+1);
            else if(j==0&& alice[i]<scores[j])
               System.out.println(rank[j]+1);
            else
             System.out.println("1");            
        }
    }
}
