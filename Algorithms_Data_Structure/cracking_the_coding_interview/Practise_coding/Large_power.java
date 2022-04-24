public class Large_power {
    public static int solve(int A, int B) {
        int m=(int)1e9+7;
        // int ans=1;
        B=factorial(B);
        // for(int i=0;i<B;i++){
        //     ans=(ans*A)%m;
        // }
        // return ans;
        // second
        //A=A%m;
        int ans=1;
        //A=A%m;
        while(B>0){
            if(B%2==0){
                A=(A*A)%m;
                B=B/2;
            }
            else{
                ans=(ans*A);
                A=(A*A);
                B=(B-1)/2;
            }
        }
        return ans;

    }
    public static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(solve(2,27));
    }
}
