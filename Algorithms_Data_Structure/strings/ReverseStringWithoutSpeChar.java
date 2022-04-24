package strings;

public class ReverseStringWithoutSpeChar {
    public  static void reverseString(char str[]){
        // Initialize left and right pointers
        int r=str.length-1,l=0;
        // Traverse string from both ends until
        // 'l' and 'r'
        while (l<r){
            // Ignore special characters
            if(!Character.isAlphabetic(str[l])){
                l++;
            }
            else if(!Character.isAlphabetic(str[r])){
                r--;
            }
            else{
                //both are alphabetics then swap the values
                char temp=str[l];
                str[l]=str[r];
                str[r]=temp;
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        String str="a!!!b.c.d,e'f,ghi";
        char[] charArray=str.toCharArray();
        System.out.println("Input string: "+str);
        reverseString(charArray);
        String revStr=new String(charArray);
        System.out.println("Reverse string: "+revStr);
    }
}
