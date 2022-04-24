import java.util.ArrayList;
import java.util.Arrays;

public class AllGCD_pair {
    public static int[] solve(int[] A) {
        Arrays.sort(A);
        ArrayList<Integer> list=new ArrayList<>();
        int n=A.length;
        for(int i=0;i<n;i++){
            if(i<n-1){
                if(A[i]!=A[i+1]){
                    list.add(A[i]);
                }
            }
            else{
                if(A[i]!=A[i-1]){
                    list.add(A[i]);
                }
            }
        }
        int size=list.size();
        int gt=list.get(size-1);
        ArrayList<Integer> list_gcd=new ArrayList<>();
        list_gcd.add(gt);
        list.remove(new Integer(gt));
        int k=size-2;
        while (list.size()>0){
            k=list.size()-1;
            int num=list.get(k);
            int g=gcd(gt,num);
            //  System.out.println(gt+" "+list.get(i)+" "+g);
            list_gcd.add(num);
            gt=list.get(k);
            list.remove(new Integer(g));
            list.remove(new Integer(num));
        }
        int n_size= list_gcd.size();
        int[]res=new int[n_size];
        for(int i=0;i<n_size;i++){
            res[i]= list_gcd.get(i);
        }
        return res;

    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        int []A={1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11};
        System.out.println(solve(A));
    }
}
