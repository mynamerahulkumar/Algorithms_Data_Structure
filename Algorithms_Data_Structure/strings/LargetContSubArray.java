package strings;

public class LargetContSubArray {
    //Utility functions to find minimum and maximum of two elements
    int min(int x,int y){
        return x>y?y:x;
    }
    int max(int x,int y){
        return x>y?x:y;
    }
    //Return the length of the longest contiguous subarray
    int findLength(int arr[],int n){
        int max_len=1;//initiliaze max result
        for(int i=0;i<n-1;i++){
            //Initialize min and max for all subarray starting with i
            int mn=arr[i],mx=arr[i];
            // consider all sub array starting with i and ending with j
            for(int j=i+1;j<n;j++){
                //Update min and max in this subarray if needed
                mn=min(mn,arr[j]);
                mx=max(mx,arr[j]);
                //If current element has all contiguous element
                if(mx-mn==j-i){
                    max_len=max(max_len,mx-mn+1);
                }
            }
        }
        return max_len;
    }
    public static void main(String[] args)
    {
        LargetContSubArray large = new LargetContSubArray();
        int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int n = arr.length;
        System.out.println("Length of the longest contiguous subarray is "
                + large.findLength(arr, n));
    }
}
