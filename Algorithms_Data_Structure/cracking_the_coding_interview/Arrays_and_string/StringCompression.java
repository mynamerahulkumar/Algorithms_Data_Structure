public class StringCompression {
    public static void main(String[] args) {
        String s1="aabcccccaaa";
        System.out.println(compressedString(s1));
    }
    static String compressedString(String s){
        StringBuilder sb=new StringBuilder();
        int len=s.length();
        int i=0;
        while(i<len){
            int cnt=1;
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                cnt++;
                i++;
            }
            sb.append(s.charAt(i));
            sb.append(cnt);
            i++;
        }
        if(sb.length()==s.length()){
            return s;
        }
        else{
            return sb.toString();
        }
    }
}
