import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QuickSort {

    static int[] quickSort(int[] arr) {
        // Complete this function
        int len=arr.length;
        int leftArr[]=new int[len];
        int rightArr[]=new int[len];
        int p=arr[0];
        int k=0;
        int j=0;
        int i=0;
        for( i=1;i<len;i++){
            if(arr[i]<=p)
                leftArr[k++]=arr[i];
            else
              rightArr[j++]=arr[i];
        }
        for(i=0;i<k;i++){
            arr[i]=leftArr[i];
        }
        arr[i++]=p;
        for(int m=0;m<j;m++){
            arr[i++]=rightArr[m];
        }
        return arr;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
