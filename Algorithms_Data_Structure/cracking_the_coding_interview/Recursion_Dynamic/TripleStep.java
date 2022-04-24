import java.util.Arrays;

public class TripleStep {
     static int countWayWithMemoization(int n,int []memo){
       if(n<0){
           return 0;
       }
       else if(n==0){
           return 1;
       }
       else if(memo[n]>-1){
           return memo[n];
       }
       else{
           memo[n]=countWayWithMemoization(n-1,memo)+countWayWithMemoization(n-2,memo)+countWayWithMemoization(n-3,memo);
           return memo[n];
       }

    }
      static int countWay(int n){
        if(n<0){
            return 0;
        }
        else if(n==0){
            return 1;
        }
        else {
            return countWay(n - 1) + countWay(n - 2) + countWay(n - 3);
        }
    }
    public static void main(String[] args) {
            int n=30;
//        long starTime=System.currentTimeMillis();
//        int step=countWay(n);
//        long endTime=System.currentTimeMillis();
//       System.out.println("Time taken "+(endTime-starTime)+" ms");
//      long starTime2=System.currentTimeMillis();
//        System.out.println(step);
        int[]memo=new int[n+1];
        Arrays.fill(memo,-1);
       int step_m=countWayWithMemoization(n,memo);
        System.out.println(step_m);
      // long endTime2=System.currentTimeMillis();
    //   System.out.println("Time taken with Memoization "+(endTime2-starTime2)+" ms");

   }
}
