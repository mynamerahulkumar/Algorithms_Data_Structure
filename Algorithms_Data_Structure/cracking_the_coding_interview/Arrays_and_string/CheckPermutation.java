/*
Check Permutation:Given two string,write a method to decide if one is permutation of other
 */
public class CheckPermutation {
    public static void main(String[] args) {
            String s1="afafaf";
            String s2="afaffa";
           System.out.println(s1+" & "+s2+" are Permutaion="+isPermutation(s1,s2));
    }
    static boolean isPermutation(String str1,String str2){
            /*
            1.create a int  array of 128 length;
            2.count the number of char in str1.
            3.subtract the number of char in str2.
            4.if the array has still 1 value return false else return true
             */
        int[]arr=new int[128];
        //base condition
        if(str1==null && str2!=null){
            return false;
        }
        if(str1!=null && str2==null){
            return false;
        }
        if(str1==null && str2==null){
            return false;
        }
        if(str1.length()!=str2.length()){
            return false;
        }
        for(int i=0;i<str1.length();i++){
            int val=str1.charAt(i);
            arr[val]++;
        }
        for(int i=0;i<str2.length();i++){
            int val=str2.charAt(i);
            arr[val]--;
        }
        for(int i=0;i<128;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
