import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int lis(int [] a){
        int n=a.length;
        int []b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=a[i];
        }
        Arrays.sort(b);
        int m=b.length;
        int [][]dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(a[i-1]==b[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis=new LongestIncreasingSubsequence();
        int []a={10,22,9,33,21,50,41,60};
        System.out.println("Longest increasing subsequence is "+lis.lis(a));


    }
}
