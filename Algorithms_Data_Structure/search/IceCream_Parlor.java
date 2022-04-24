import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//bruteforce
public class IceCream_Parlor {

    static int[] icecreamParlor(int m, int[] arr) {
        // Complete this function
        int lowId=0;
        int highId=0;
        int len=arr.length;
        int count=0;
        int fnd=0;
        int []res=new int[2];
        for(int i=0;i<len-1;i++){
        	count=arr[i];
        		for(int j=0;j<len;j++){
        			if(j!=i){
        				if(count+arr[j]==m){
        					if(i<j){
        						lowId=i+1;
        						highId=j+1;
        					}
        					else{
        					lowId=j+1;
        					highId=i+1;
        					}
        					fnd=1;
        					break;
        				}
        			}
        		}
        		if(fnd==1){
        		break;
        		}
        }
        res[0]=lowId;
        res[1]=highId;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
