public class Odd_fibonacci {
    public static int solve(int A, int B) {
     //   int[]f=new int[B+1];
        int odd_cnt=0;
        int f1,f2,f3;
        if(A<=2){
            f1=0;
            f2=1;
            if(A==1){
                odd_cnt++;
            }
            f3=0;
            for(int i=2;i<=B;i++){
                f3=f2+f1;
                f2=f3;
                f1=f2;
                if(f3%2!=0){
                    odd_cnt++;
                }
            }

        }
        else{
            f1=1;
            f2=1;
            for(int i=3;i<A;i++){
                f3=f2+f1;
                f2=f3;
                f1=f2;
            }
            for(int i=A;i<=B;i++){
                f3=f2+f1;
                f2=f3;
                f1=f2;
                if(f3%2!=0){
                    odd_cnt++;
                }
            }
        }
        return odd_cnt;
    }

    public static void main(String[] args) {
        int A=32;
        int B=36;
        System.out.println(solve(A,B));
    }
}
