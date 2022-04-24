public class MaxAbsoluteDiff {
    public int maxArr(int[] A) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;
        int min1=Integer.MAX_VALUE;
        int n=A.length;
        for(int i=0;i<n;i++){
            max1=Math.max(A[i]+i,max1);
            min1=Math.min(A[i]+i,min1);
            max2=Math.max(A[i]-i,max2);
            min2=Math.min(A[i]-i,min2);
        }
        return Math.max(max1-min1,max2-min2);

    }

    public static void main(String[] args) {
        MaxAbsoluteDiff maxAbsoluteDiff=new MaxAbsoluteDiff();
        int[]A={1,3,-1};
        System.out.println(maxAbsoluteDiff.maxArr(A));
    }
}
