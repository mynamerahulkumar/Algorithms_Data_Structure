public class UrilFy {
    public static void main(String[] args) {
        String ip="Mr John Smith    ";
        System.out.println(urilfy(ip));

    }
    static String urilfy(String str){
        if(str==null||str.length()==0){
            return "";
        }
        char[]chr=new char[str.length()];
        // find the last index of letter;
        int cntIdx=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                cntIdx=i;
            }
        }
        int j=0;
        for(int i=0;i<=cntIdx;i++){
            if(str.charAt(i)==' '){
                chr[j++]='%';
                chr[j++]='2';
                chr[j++]='0';
            }
            else{
                chr[j++]=str.charAt(i);
;            }
        }
        for(int i=0;i<str.length();i++){
           // System.out.print(chr[i]);
        }
        String res=String.valueOf(chr);
        return res;
    }
}
