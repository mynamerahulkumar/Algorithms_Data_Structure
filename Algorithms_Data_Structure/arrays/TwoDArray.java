import java.io.*;
import java.util.*;

public class TwoDArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int[][]arr =new int[6][6];
        int sum=0,max=-9999;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<=3;i++){
            for(int j=0;j<=3;j++){
                sum=arr[i][j] + arr[i][j+1] +arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] +arr[i+2][j+1] +arr[i+2][j+2];
                if(sum>max){
                    max=sum;
                }
            }
        }
        System.out.println(max);
        
    }
}