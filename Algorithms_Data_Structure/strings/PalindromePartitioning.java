package strings;

public class PalindromePartitioning {
    //Return the minimum number of cuts needed
    //to partition string that every substring is palindrome
    static int minPalindromePartition(String str){
        //Get the lenght of string
        int n=str.length();
        /*
            Create two arrays to build the solution in bottom up manner
            C[i][j]=Minimum number of cuts needed for palindrom partitioning
                    of substring str[i...j]
            P[i][j]=true if substring str[i...j] is palindrome else false
            Note that C[i][j] is 0 if P[i][j] is true*/
        int [][]C=new int[n][n];
        boolean [][]P =new boolean[n][n];
        int i,j,k,L;
        //assuming all string of 1 lenght is palindrome
        for( i=0;i<n;i++){
            for(j=0;j<n;j++){
                P[i][j]=true;
                C[i][j]=0;
            }
        }
        /*
        L is substring length.Build the solution in bottom up manner by considering all substrings
        of length starting from 2 to n.The loop structure is same as Matrix chain multiplication problem
         */
        for(L=2;L<=n;L++){
            // for substring of Length L,set different
            //possible starting index
            for(i=0;i<n-L+1;i++){
                j=i+L-1;// ending index
                //if L is 2 ,then we just need to
                //compare two characters .Else need to
                //Check two corners characters and value
                //of P[i+1][j-1]
                if(L==2){
                    P[i][j]=str.charAt(i)==str.charAt(j);
                }
                else{
                    P[i][j]=str.charAt(i)==str.charAt(j) && P[i+1][j-1];
                }
                //If str[i...j] is palindrome ,then
                //C[i][j]=0
                if(P[i][j]==true){
                    C[i][j]=0;
                }
                else{
                    /*
                    Make a cut for every possible location starting from i to j
                    and get the minimum cost cut.
                     */
                    C[i][j]=Integer.MAX_VALUE;
                    for(k=i;k<=j-1;k++){
                        C[i][j]=Integer.min(C[i][j],C[i][k]+C[k+1][j]+1);
                    }
                }
            }
            //Return the minimum cut value for complete string i.e str[0...n-1]
        }
        return C[0][n-1];
    }

    public static void main(String[] args) {
        String str="ababbbabbababa";
        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is " + minPalindromePartition(str));
    }
}
