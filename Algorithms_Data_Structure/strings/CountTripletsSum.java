package strings;

import java.util.Arrays;

public class CountTripletsSum {
    static int []arr=new int[]{5, 1, 3, 4, 7};
    static int countTriplets(int n,int sum){
        //Sort the array.
        Arrays.sort(arr);
        //Initialize the result 0
        int ans=0;
        //Every iteration of loop count triplets with
        //first element as arr[i]
        for(int i=0;i<n-2;i++){
            //Initialize other two elements as corner elements
            //of subarray arr[j+1..k]
            int j=i+1,k=n-1;
            //Use Meet in the middle concept
            while (j<k){
                //if sum of triplet is greater than or equal to
                //move right corner to look for smaller value
                if(arr[i]+arr[j]+arr[k]>=sum){
                    k--;
                }
                //Else move left
                else{
                    //This is important.For current I and J,there can be total k-j elements
                    ans+=(k-j);
                    j++;
                }
            }
        }
        return ans;
    }
    // Driver method to test the above function
    public static void main(String[] args)
    {
        int sum = 12;
        System.out.println(countTriplets(arr.length, sum));
    }
}
