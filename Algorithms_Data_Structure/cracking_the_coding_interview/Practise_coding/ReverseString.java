public class ReverseString {
    public String solve(String A) {

        A=A.trim();
        int n=A.length();
        char[]chr=new char[n];
        int k=0;
        // reverse the whole string
        //A.charAt(n-1);
        for(int i=n-1;i>=0;i--){
            chr[k]=A.charAt(i);
            k++;
        }
        // reverse word by word
      //  System.out.println("reverse string: "+ String.copyValueOf(chr));
        for(int i=0;i<n;i++) {
            //find first word length;
            k = i;
            while (i < n && chr[i]!=' ') {
                i++;
            }
            int r = i - 1;
            int cnt=(r-k)/2;
            int j=k;
            while(cnt>=0 && r>=0 && k<n){
                char temp=chr[k];
                chr[k]=chr[r];
                chr[r]=temp;
                r--;
                k++;
                cnt--;
            }
            if(i<n-1){
               chr[i]=' ';
            }

        }
        return String.copyValueOf(chr);
    }

    public static void main(String[] args) {
        String str="crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv";
        ReverseString reverseString=new ReverseString();

        System.out.println(reverseString.solve(str));
    }
}
