public class Ndigit {
        public int solve(int A, int B) {
            int mod=(int)1e9+7;
            int[][]count=new int[A+1][B+1];
            for(int i=1;i<=A;i++){
                for(int j=1;j<=B;j++){
                    if(i==1){
                        count[i][j]=(j<=9?1:0);
                    }
                    else{
                        for(int k=0;k<=9;k++){
                            if(j>k){
                                count[i][j]+=(count[i-1][j-k])%mod;
                                count[i][j]=count[i][j]%mod;

                            }
                        }
                    }
                }
            }
            return count[A][B];
        }

    public static void main(String[] args) {
        Ndigit obj=new Ndigit();
        System.out.println(obj.solve(2,4));
        /*
        Valid numbers are {22, 31, 13, 40}
 Hence output 4.
 //https://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/);
         */
    }

}
