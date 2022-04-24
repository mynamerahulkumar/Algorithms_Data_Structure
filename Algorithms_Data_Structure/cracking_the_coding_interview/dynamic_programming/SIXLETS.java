public class SIXLETS {
    public int solve(int[] A, int B) {
        /*
            1.Its a recursion problem.
            2.create three variable index i=0,sum=0,size=B;
            3.(0,0,3) for index 0 either we accept the index 0 and add it to sum or reject.
            4.Pruning condition  and sum >1000 and it reached the end return 0;
            5. if size =0 then it has matched the condition return 1.
            6.sixLetsSolve(i+1,sum+A[i],size-1,A)+sixLetsSolve(i+1,sum,size,A)
        */
        int res=sixLetsSolve(0,0,B,A);
        return res;

    }
    public int sixLetsSolve(int i,int sum,int size,int[]A){
        if(sum>1000){
            return 0;
        }
        if(size==0){
            return 1;
        }
        if(i==A.length){
            return 0;
        }
        return sixLetsSolve(i+1,sum+A[i],size-1,A)+sixLetsSolve(i+1,sum,size,A);

    }

    public static void main(String[] args) {
        SIXLETS obj= new SIXLETS();
        int[]A={5, 17, 1000, 11};
        int B=4;
        System.out.println(obj.solve(A,B));
    }
}
