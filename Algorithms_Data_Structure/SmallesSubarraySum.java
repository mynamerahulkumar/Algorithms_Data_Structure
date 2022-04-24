package strings;

public class SmallesSubarraySum {
    //Returns length of smalles subarray with sum greater than x
    // if there is no subarray with given sum ,then return n+1
    static  int smallesSubWithSum(int arr[],int n,int x){
        //Intialize current sum and min_length
        int curr_sum=0;
        int min_len=n+1;
        //Intialize starting and ending point
        int start=0,end=0;
        while (end<n){
            //keep adding array element while current sum
            //is smaller than x
            while (curr_sum<=x && end<n){
                curr_sum+=arr[end++];
            }
            // if current sum becomes greater than x
            while (curr_sum>x && start<n){
                //Update min length if needed
                if(end-start<min_len){
                    min_len=end-start;
                }
                //remove starting element
                curr_sum-=arr[start++];
            }
        }
        return min_len;
    }
    // Driver program to test above functions
    public static void main(String[] args)
    {
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallesSubWithSum(arr1, n1, x);
        if (res1 == n1+1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);

        int arr2[] = {1, 10, 5, 2, 7};
        int n2 = arr2.length;
        x = 9;
        int res2 = smallesSubWithSum(arr2, n2, x);
        if (res2 == n2+1)
            System.out.println("Not Possible");
        else
            System.out.println(res2);

        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n3 = arr3.length;
        x = 280;
        int res3 = smallesSubWithSum(arr3, n3, x);
        if (res3 == n3+1)
            System.out.println("Not Possible");
        else
            System.out.println(res3);
    }


}
