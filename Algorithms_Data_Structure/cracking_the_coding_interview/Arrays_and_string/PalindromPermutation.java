import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PalindromPermutation {
    public static void main(String[] args) {
        String ip="Tact coa";
        ip=ip.toLowerCase(Locale.ROOT);
        System.out.println(isPermutationOfPalindrom(ip));
    }
    //solution 1 using bit map to reduce space
   static boolean isPermutationOfPalindrom(String phrase){
        int bitVector=createVector(phrase);
        return bitVector==0||CheckExactlyOneBitSet(bitVector);
    }
    static int createVector(String phrase){
        int bitVector=0;

        for(char c:phrase.toCharArray()){
            int x=getCharNumber(c);
            bitVector=toggle(bitVector,x);
        }
        return bitVector;
    }
   static int toggle(int bitVector,int index){
        if(index<0){
            return bitVector;
        }
        int mask=1<<index;
        if((bitVector&mask)==0){
            bitVector|=mask;
        }
        else{
            bitVector&=~mask;
        }
        return bitVector;

    }
    static boolean CheckExactlyOneBitSet(int bitVector){
        return (bitVector&(bitVector-1))==0;
    }
    static int getCharNumber(char c){
        int a=Character.getNumericValue('a');
        int z=Character.getNumericValue('z');
        int val=Character.getNumericValue(c);
        if(a<=val && val<=z){
            return val-a;
        }
        else{
            return -1;
        }
    }


    //solution 2 using map

    /*
    static boolean isPermutation(String str){
        if(str==null ||str.length()==0){
            return true;
        }
        int cntChar=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
               int idx=str.charAt(i)-'a';
               int cnt=map.getOrDefault(idx,0)+1;
               map.put(idx,cnt);
               cntChar++;
            }
        }
        if(cntChar%2==0){
            for(Map.Entry<Integer,Integer>element:map.entrySet()){
                if(element.getValue()%2!=0){
                    return false;
                }
            }
        }
        else{
            int cntOdd=0;
            for(Map.Entry<Integer,Integer>element:map.entrySet()){
                if(element.getValue()%2!=0){
                    cntOdd++;
                }
                if(cntOdd>1){
                    return false;
                }
            }
        }
        return true;


    }*/
}
