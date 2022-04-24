public class DeleteOne {
    public static int solve(int[] A) {
        int n=A.length;
        int []prefix_gcd=new int[n+1];
        int[]suffix_gcd=new int[n+1];
        prefix_gcd[0]=0;
        for(int i=1;i<=n;i++){
            prefix_gcd[i]=gcd(prefix_gcd[i-1],A[i-1]);
        }
        suffix_gcd[n]=0;
        for(int i=n-1;i>=0;i--){
            suffix_gcd[i]=gcd(suffix_gcd[i+1],A[i]);
        }
        int max_gcd=0;
        for(int i=0;i<n;i++){
            max_gcd=Math.max(gcd(prefix_gcd[i],suffix_gcd[i+1]),max_gcd);
        }
        return max_gcd;

    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
            int []A={ 21, 7, 3, 42, 63};
        System.out.println(solve(A));
    }
}
