import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Magic_Square {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        //  Print the minimum cost of converting 's' into a magic square
        /*
        compare first three rows of total matrix with original matirx.Get the differecne of 8 combination.
        Find min in 8 combination e.g {4, 9, 2}, {3, 5, 7}, {8, 1, 6} with {4, 9, 2}, {3, 5, 7}, {8, 1, 5} diff is 1
        */
            
        
           int[][]tM={
            {8, 1, 6}, {3, 5, 7}, {4, 9, 2},
            {6, 1, 8}, {7, 5, 3}, {2, 9, 4},
            {4, 9, 2}, {3, 5, 7}, {8, 1, 6},
            {2, 9, 4}, {7, 5, 3}, {6, 1, 8}, 
            {8, 3, 4}, {1, 5, 9}, {6, 7, 2},
            {4, 3, 8}, {9, 5, 1}, {2, 7, 6}, 
            {6, 7, 2}, {1, 5, 9}, {8, 3, 4}, 
            {2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int[]arr=new int[9];
        int index=0;
        int sum=0,diff=0;
        for(int i=0;i<24;){
            sum=0;
            for(int k=0;k<3;k++,i++){
                diff=0;
                for(int j=0;j<3;j++){
                    diff+=Math.abs(tM[i][j]-s[k][j]);
                }
                        //System.out.println(diff);

                sum+=diff;
            }
            arr[index++]=sum;
        }
        int min=999999;
        int fnd=0;
        for(int i=0;i<8;i++){
            if(min>arr[i]){
                min=arr[i];
               // fnd=min;
                       // System.out.println(min);

            }
        }
        System.out.println(min);
       
       
    }
}
