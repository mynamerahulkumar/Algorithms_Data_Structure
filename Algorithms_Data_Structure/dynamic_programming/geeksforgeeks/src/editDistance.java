public class editDistance {
/*
https://www.geeksforgeeks.org/edit-distance-dp-5/
 */
    int editDistDP(String str1, String str2, int m, int n){
        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                else if(j==0){
                    dp[i][j]=i;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
                }
            }

        }
        return dp[m][n];
    }
    int min(int k,int l,int m){
        if(k<=l && k<=m){
            return k;
        }
        else if(l<=m && l<=k){
            return l;
        }
        else{
            return m;
        }
    }
    public static void main(String[] args) {
        editDistance ed=new editDistance();
        String str1="sunday";
        String str2="saturdday";
        System.out.println("Minimum edit distance required-"+ed.editDistDP(str1,str2,str1.length(),str2.length()));
    }
}
