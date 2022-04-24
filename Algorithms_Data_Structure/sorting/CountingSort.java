import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSort {

    static int[] countingSort(int[] arr) {
        // Complete this function
         int len=arr.length;
        int[]countArr=new int[100];
        for(int i=0;i<len;i++)
            countArr[arr[i]]++;
        int[]result=new int[len];
        int k=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<countArr[i];j++){
                result[k]=i;
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = countingSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
