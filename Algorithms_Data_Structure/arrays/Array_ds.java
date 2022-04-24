import java.io.*;
import java.util.*;

public class Array_ds {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
            int n;
            int[]arr=new int[1000];
            n=sc.nextInt();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            for(int i=n-1;i>=0;i--){
                System.out.print(arr[i]+" ");
            }
        
    }
}