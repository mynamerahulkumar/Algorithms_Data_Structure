public class TrappedWater {
    public static int trap(final int[] A) {
        int left=0;
        int right=0;
        int n=A.length;
        if(n<=2){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(A[i]>0){
                left=i;
                break;
            }
        }
        for(int j=left+1;j<n;j++){
            if(A[j]!=0){
                right=j;
                break;
            }
        }
        int area=0;
        while(right<n && left<n){
            area=Math.max((right-left)*Math.min(A[left],A[right]),area);
            if(A[left]<A[right]){
                left=right;
            }
            boolean baundaryFnd=false;
            for(int j=right+1;j<n;j++){
                if(j<n-1 && A[j]==0 && A[j+1]!=0 ){
                    right=j+1;
                    baundaryFnd=true;
                    break;
                }
            }
            if(!baundaryFnd){

            }
        }
        return area;


    }
    public static void main(String[] args) {
        int []A={0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(A));
    }
}
