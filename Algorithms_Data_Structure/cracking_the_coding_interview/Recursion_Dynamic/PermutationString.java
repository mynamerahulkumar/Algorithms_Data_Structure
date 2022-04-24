public class PermutationString {
    public void solve(String prefix,int[]freq,int N){
        if(prefix.length()==N){
            System.out.println(prefix);
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                freq[i]--;
                solve(prefix+(char)(i+'a'),freq,N);
                freq[i]++;
            }
        }
    }

    public static void main(String[] args) {
        PermutationString perm=new PermutationString();
        int[]freq=new int[26];
        String s="abc";
        for(int i=0;i<s.length();i++){
            int a=s.charAt(i)-'a';
            freq[a]++;
        }
        perm.solve("",freq,3);

    }
}
