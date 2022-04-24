package geekForGeeks.Graphs;

import java.util.LinkedList;

/*
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in
 the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5],
[5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 */
public class Subarray {
    public static void main(String[] args) {
//        int [] arr={10, 5, 2, 6};
//        int k = 100;
//        int arr_len=arr.length;
//        int cnt=0; //1,2,3,4,5,6,7
//        //10*5=50
//        //50*2
//        //2,5,6,10
//        //10,5,2,6=4
//        //
//
//
//        /*
//             0 1 2
//        10     50 20 60
//        5
//        2
//        6
//        int p=1;
//
//
//
//
//         */
//        //10,5,2,6
//        int p=1;
//        while (p<arr_len) {
//            for (int i = 0; i < arr_len; i++) {
//                for (int j = i; j < i + p; j++) {
//
//                }
//            }
//            p++;
//        }
//
//
//
//
//        //10 5 2 6
//
//        //
//        /*
//        10* 5=50
//        10*5*2*6=600
//
//        10  10*1
//        50   10*5
//        100  10*5*2
//        600  10*5*2*6
//         */
//
//
//
//        for(int i=0;i<arr_len;i++){
//            int mult=1;
//            if(arr[i]<100){
//                cnt++;
//            }
//            mult*=arr[i];
//            for(int j=i+1;j<arr_len;j++){
//                mult*=arr[j];
//                if(mult>=100){
//                    break;
//                }
//                else{
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
        int a=013;
        System.out.println(a);
        LinkedList obj=new LinkedList();
        obj.add("d");
        obj.add("c");
        obj.add("a");
        System.out.println(obj);
    }
}
