public class MinSwap {
    /*
      1.Find the position of B
      2.Find the number of element less<position B is greater than B then we have to swap it
  */
    public int solve(int[] A, int B) {
        int swap=Integer.MAX_VALUE;
        int pos=findPosition(A,B);
        System.out.println(pos+"-");//[1, 12, 10, 3, 14, 10, 5] 8
        int n=A.length;
        for(int i=0;i<n-pos;i++){
            int k=0;
            int cnt=0;
            for(int j=i;j<n && k<pos;j++){
                if(A[i]>B){
                    cnt++;
                }
                System.out.println(A[i]+"-cnt");
                k++;
            }
            if(cnt>0){
                swap=Math.min(swap,cnt);
            }
        }
        return swap;

    }
    public int findPosition(int[]A,int B){
        int pos=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<B){
                pos++;
                System.out.println(A[i]);
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[]A={1, 12, 10, 3, 14, 10, 5 };
       // {1, 3, 10, 12, 14,8, 10, 5};
       // {7,5,17,5,3,16,9,7,11,5,10}
        int B=8;
        MinSwap obj=new MinSwap();
        System.out.println(obj.solve(A,B));
    }
}
