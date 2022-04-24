import java.util.ArrayList;
import java.util.List;

public class Array2 {
    public  static int[] flip(String A) {
        int ans=0;
        int cnt=0;
        int n=A.length();
        // find number of occurence of 1
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='1'){
                cnt++;
            }
        }
        ans=cnt;
        String res="";
        ans=cnt;
        int []resArr={};
        if(ans==n){
            //  resArr={};
            return resArr;
        }
        resArr= new int[2];
        if(ans==0){
            resArr[0]=1;
            resArr[1]=n;
            return resArr;
        }
        int count0=0,count1=0;
        for(int i=0;i<n;i++){// start of subarray
            count0=0;
            count1=0;
            for(int j=i;j<n;j++){ // end of subarray
                if(A.charAt(j)=='1'){
                    count1++;
                }
                else{
                    count0++;
                }
                ans=Math.max(ans,cnt+(count0-count1));
            }
        }
        // find the index of larger occurence
        int max_ans=ans;
        ans=cnt;
        List<List<Integer>> arrayList=new ArrayList<>();
        resArr[0]=Integer.MAX_VALUE;
        resArr[1]=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            count0=0;
            count1=0;
            for(int j=i;j<n;j++){ // end of subarray
                if(A.charAt(j)=='1'){
                    count1++;
                }
                else{
                    count0++;
                }
                ans=Math.max(ans,cnt+(count0-count1));
                if(ans==max_ans){
                   if(!lexiGrophically(resArr,i+1,j+1)){
                       resArr[0]=i+1;
                       resArr[1]=j+1;
                   }
                }

            }
        }
//        char c1=res.charAt(0);
//        char c2=res.charAt(1);
//        int start=Integer.valueOf(c1-'0');
//        int end=Integer.valueOf(c2-'0');
//        resArr[0]=start;
//        resArr[1]=end;
        return resArr;

    }
    public static boolean lexiGrophically(int []arr,int c,int d){
        int a=arr[0];
        int b=arr[1];
        if(a<c){
            return true;
        }
        if(a==c && b<d){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
       String a="010";
       flip(a);

    }
}
