import java.io.*;
import java.util.*;
import java.math.*;


public class Extra_long_factorial {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*https://stackoverflow.com/questions/26104221/bigintegerlong-has-private-access-in-biginteger
        https://www.tutorialspoint.com/java/math/biginteger_multiply.htm
        */
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        BigInteger bi1,bi2;
        bi1=BigInteger.valueOf(n);
        while(n>1){
            bi2=BigInteger.valueOf(n-1);
            bi1=bi1.multiply(bi2);
            n--;
        }
        System.out.println(bi1);
        
    }
}