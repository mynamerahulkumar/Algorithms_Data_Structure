public class LongetCommonSubsequence {

    /* solution-1
        Recursive question
             time=(2^n) since some are repeating input
     */
    public  int lcs(char[]X,char[]Y,int m,int n){
        if(n==0||m==0){
            return 0;
        }
        if(X[m-1]==Y[n-1]){
            return 1+lcs(X,Y,n-1,m-1);
        }
        else{
            return Math.max(lcs(X,Y,m-1,n),lcs(X,Y,m,n-1));
        }
    }
    /*
    solution 2-using memoization

     */
    int lcs_memo(char[]X,char[]Y,int m,int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];// corner side
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //top or adjacent max
                }
               /*
                    0 1 2
                    0  2
                */
             }
            }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongetCommonSubsequence lcs = new LongetCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs( X, Y, m, n ) );
        System.out.println("Length of LCS is usong memoization" + " " +
                lcs.lcs_memo( X, Y, m, n ) );
    }

}
