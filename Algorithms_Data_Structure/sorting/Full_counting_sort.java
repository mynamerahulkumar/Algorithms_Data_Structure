import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
1.Divide the arr into 2 parts
2.If number is present in first part print "-"
3.If number i is present in second half
4.Find the position from original second half
5.print corresponding result from origina str array



*/
public class Full_counting_sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]arr=new int[n];
        String[]strArr=new String[n];
        StringBuilder res=new StringBuilder();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            String s = in.next();
            arr[a0]=x;
            strArr[a0]=s;
        }
        int[]firstHalf=new int[100];
        int[]secondHalf=new int[100];
        for(int i=0;i<n/2;i++){
            firstHalf[arr[i]]++;
        }
        for(int i=n/2;i<n;i++){
            secondHalf[arr[i]]++;
        }
        for(int i=0;i<100;i++){
            if(firstHalf[i]>0){
                for(int m=0;m<firstHalf[i];m++)
                res.append("-"+" ");
            }
            if(secondHalf[i]>0){
                for(int m=n/2;m<n;m++){
                    if(i==arr[m]){
                       res.append(strArr[m]+" ");
                    }
                }
            }
        }
        System.out.print(res);
        in.close();
    }
}
