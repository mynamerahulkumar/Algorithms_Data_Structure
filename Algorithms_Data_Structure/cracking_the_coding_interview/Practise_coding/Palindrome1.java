public class Palindrome1 {
    public String solution(String S) {
        // write your code in Java SE 8
        int n=S.length();
        int l=0;
        int r=n-1;
        boolean isPalindrome=true;
        StringBuilder sb=new StringBuilder(S);
        while(l<r){
            if(S.charAt(l)=='?'){
                if(S.charAt(r)!='?'){
                    char c=S.charAt(r);
                    sb.setCharAt(l,c);
                    sb.setCharAt(r,c);
                }
                else{
                    sb.setCharAt(l,'a');
                    sb.setCharAt(r,'a');
                }
            }
            else if(S.charAt(r)=='?'){
                if(S.charAt(l)!='?'){
                    char c=S.charAt(l);
                    sb.setCharAt(l,c);
                    sb.setCharAt(r,c);
                }
                else{
                    sb.setCharAt(l,'a');
                    sb.setCharAt(r,'a');
                }
            }
            else if(S.charAt(l)==S.charAt(r)){
                char c=S.charAt(l);
                sb.setCharAt(l,c);
                sb.setCharAt(r,c);
            }
            else{
                isPalindrome=false;
            }
            l++;
            r--;
        }
        if(isPalindrome){
            return sb.toString();
        }
        else{
            return "NO";
        }

    }

    public static void main(String[] args) {
        Palindrome1 ob=new Palindrome1();
        System.out.println(ob.solution("?ab??a"));
    }
}
