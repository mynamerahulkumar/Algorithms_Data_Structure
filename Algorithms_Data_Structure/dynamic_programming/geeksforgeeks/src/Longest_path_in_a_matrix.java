public class Longest_path_in_a_matrix {
    static int fingLongestFromCell(int i, int j, int[][] mat, int[][] dp, int n){
        if(i<0 || i>=n || j<0 || j>=n){
            return 0;
        }
        // if this problem already solved
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //To store the path length in all the four directions
        int x=Integer.MIN_VALUE,y=Integer.MIN_VALUE,z=Integer.MIN_VALUE,w=Integer.MIN_VALUE;
        // since all numbers are unique and in range from 1 to n*n
        // there is atmost one possible directions from any cell
        if(j<n-1 &&((mat[i][j]+1)==mat[i][j+1])){
            x=dp[i][j]=1+fingLongestFromCell(i,j+1,mat,dp,n);
        }
        if(j>0 && (mat[i][j]+1==mat[i][j-1])){
            y=dp[i][j]=1+fingLongestFromCell(i,j-1,mat,dp,n);
        }
        if(i>0 && (mat[i][j]+1==mat[i-1][j])){
            z=dp[i][j]=1+fingLongestFromCell(i-1,j,mat,dp,n);
        }
        if(i<n-1 && (mat[i][j]+1==mat[i+1][j])){
            w=dp[i][j]=1+fingLongestFromCell(i+1,j,mat,dp,n);
        }
        // if none of the adjacent fours is one greater we will take 1
        // otherwise we will pick maximum from all the four directions
        return dp[i][j]=Math.max(x,Math.max(y,Math.max(z,Math.max(w,1))));
    }
    public static void main(String[] args) {
        int mat[][]={{1,2,9},
                {5,3,8},
                {4,6,7}};
        int result=1;
        int n=1;
        int[][]dp=new int[n][n];
        //create a lookup table and fill all entries in it as -1
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        //computer longest path begining from all cells
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==-1){
                    fingLongestFromCell(i,j,mat,dp,n);
                }
                result=Math.max(result,dp[i][j]);
            }
        }
        System.out.println(result);
    }
}
