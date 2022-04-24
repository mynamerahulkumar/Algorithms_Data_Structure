public class LongestCommonSubsequence {
    /*
    1) Optimal Substructure:
Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y. Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

If last characters of both sequences match (or X[m-1] == Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )
     */
    int lcs(char[]X,char[]Y,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(X[m-1]==Y[n-1]){
            return 1+lcs(X,Y,m-1,n-1);
        }
        else{
            return Math.max(lcs(X,Y,m,n-1),lcs(X,Y,n,m-1));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs=new LongestCommonSubsequence();
        String s1="AGGTAB";
        String s2="GXTXAYB";
        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m=X.length;
        int n=Y.length;
        System.out.println("Longest common subsequence length :"+lcs.lcs(X,Y,m,n));
    }
}
