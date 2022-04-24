public class Count_vowel_substring {
    int[]vowel_cnt=new int[5];
    public int countVowelSubstrings(String word) {
        /*
         1.store the presence of vowel in five len array
         2.iterate in brute force way
         3.i=0 to n-2 check with every letter
         4.j=i+1 to n-1 check the combination if it vowel
        */

        int n=word.length();
        int ans=0;
        if(n<5){
            return 0;
        }
        for(int i=0;i<n-5;i++){
            if(isVowel(word.charAt(i))){
                int cnt=1;
                for(int j=i+1;j<n;j++){
                    if(isVowel((word.charAt(j)))){
                        cnt++;
                    }
                    else {
                        break;
                    }
                    if(cnt>=5){
                        if(isAllVowel(word.substring(i,j+1))){
                            ans++;
                        }
                    }

                }

                decr_vowel(word.charAt(i));
            }

        }
        return ans;
    }


    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
    public void incr_vowel(char c){
        if(c=='a'){
            vowel_cnt[c-'a']++;
        }
        else if(c=='e'){
            vowel_cnt[c-'e'+1]++;
        }
        else if(c=='i'){
            vowel_cnt[c-'i'+2]++;
        }
        else if(c=='o'){
            vowel_cnt[c-'o'+3]++;
        }
        else if(c=='u'){
            vowel_cnt[c-'u'+4]++;
        }
    }
    public void decr_vowel(char c){
        if(c=='a'){
            if(vowel_cnt[c-'a']>0){
                vowel_cnt[c-'a']--;
            }
        }
        else if(c=='e'){
            if(vowel_cnt[c-'e'+1]>0){
                vowel_cnt[c-'e'+1]--;
            }

        }
        else if(c=='i'){
            if(vowel_cnt[c-'i'+2]>0){
                vowel_cnt[c-'i'+2]--;
            }
        }
        else if(c=='o'){
            if(vowel_cnt[c-'o'+3]>0){
                vowel_cnt[c-'o'+3]--;
            }
        }
        else if(c=='u'){
            if(vowel_cnt[c-'u'+4]>0){
                vowel_cnt[c-'u'+4]--;
            }
        }
    }
    public boolean isAllVowel(String sub){
        int n=sub.length();
        for(int i=0;i<n;i++){
            if(!isVowel((sub.charAt(i)))){
                return false;
            }

        }
        for(int i=0;i<n;i++){
            incr_vowel(sub.charAt(i));
        }

        for(int i=0;i<5;i++){
            if(vowel_cnt[i]<=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str="cuaieuouac";
        Count_vowel_substring object=new Count_vowel_substring();
        System.out.println(object.countVowelSubstrings(str));
    }
}
