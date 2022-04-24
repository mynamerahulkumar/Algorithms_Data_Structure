/*
Is unique :Implement an algorithm to determine if a string has all unique characters .
What if you cannot use additional data structure.
hint:
https://www.geeksforgeeks.org/efficiently-check-string-duplicates-without-using-additional-data-structure/
 */
public class IsUnique {
    /*
    Return true if all character of str are unique
    Assumptions i) str contains only characters from 'a' to 'z'
    ii)integers are stored using 32 bits

     */
    public static void main(String[] args) {
        String s = "aaabbccdaa";

        if (arecharacterUnique(s))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
    static  boolean arecharacterUnique(String str){
        //An integer to store presence /absence of 26 characters using its 32 bits
        int checker=0;
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i)-'a';
            //if bit corresponding to val is already set
            if((checker & (1<<val))>0){
                return false;
            }
            //set the bit in checker
            checker|=(1<<val);
        }
        return false;
    }
}
