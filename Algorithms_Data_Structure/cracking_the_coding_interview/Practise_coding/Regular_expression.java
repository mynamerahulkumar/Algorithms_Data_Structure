public class Regular_expression {
    public static boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            else if(p.charAt(j)=='.'){
                i++;
                j++;
            }
            else if(j<n2-1 && p.charAt(j+1)=='*'){
                if(j>0 && (s.charAt(i)==p.charAt(j-1) ||(p.charAt(j-1)=='.'))){
                    i++;
                    j++;
                }
                else if(s.charAt(i)!=p.charAt(j)){
                    j+=2;
                }
            }
            else if(p.charAt(j)=='*'){
                if(j>0 && (s.charAt(i)==p.charAt(j-1) ||(p.charAt(j-1)=='.'))){
                    i++;
                    j++;
                }
            }
            else{
                break;
            }
        }
        return i==n1;

    }

    public static void main(String[] args) {
        String s="aab";
        String p="c*a*b";
        System.out.println(isMatch(s,p));
    }

}
