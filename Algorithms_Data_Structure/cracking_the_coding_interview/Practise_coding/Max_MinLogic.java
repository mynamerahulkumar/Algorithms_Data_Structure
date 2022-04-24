public class Max_MinLogic {
    public int[] solve(int[] A) {
        /*
            method 1)using include and exclude method
            step 1)create a temporary array of length n/2;
            step 2) using recursion method, first time we include the index and other time we dont include the index
            step 3) if index of r formed then calculate sum and resultarr according to min ,max condition
        */
        int[]res=new int[2];
        int n=A.length;
        int[]data=new int[n];
        res[0]=Integer.MIN_VALUE;
        res[1]=Integer.MAX_VALUE;
        combinationUtil(A,data,0,n,0,res);
        return res;


    }
    public void combinationUtil(int[]A,int[]data,int index,int n,int i,int[]res){
        if(index==n){ // if we have included all value of A
            int sum=0;
            int k=n/2;
            for(int j=0;j<n/2 && k<n;j++){
                sum+=Math.abs(A[j]-A[k]);
                k++;
            }
            if(sum>res[0]){//max value set
                res[0]=sum;
            }
            if(sum<res[1]){// min value set
                res[1]=sum;
            }
            System.out.println(res[0]+"--"+res[1]);
            return;
        }
        if(i>=n){
            return;// there is no element
        }
        // include the index and increase the index by 1
        data[index]=A[i];
        combinationUtil(A,data,index+1,n,i+1,res);
        // remove the duplicate index;
        while(i<n-1 && A[i]==A[i+1]){
            i++;
        }
        // don't included the index
        combinationUtil(A,data,index,n,i+1,res);
    }
    public static void main(String[] args){
        Max_MinLogic obj=new Max_MinLogic();
        int n=4;
        int[]arr=new int[n];
        arr[0]=3;
        arr[1]=11;
        arr[2]=-1;
        arr[3]=5;
        obj.solve(arr);
    }
}
