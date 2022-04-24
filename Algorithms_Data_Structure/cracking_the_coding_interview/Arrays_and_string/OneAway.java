public class OneAway {
    public static void main(String[] args) {
        String s1="pale";
        String s2="bake";
        System.out.println(isOneAway(s1,s2));
    }
    // assume s>=0 and t>=0 (length)
    static  boolean isOneAway(String s,String t){
        boolean isOneEditAway=false;
        if(s.length()==0 && t.length()==0){
            return true;
        }
        int len1=s.length();
        int len2=t.length();
        int diff=Math.abs(len1-len2);
        if(diff>1) {
            return false;
        }
        if(s.equals(t)){
            return true;
        }
        if(s.length()==t.length()){
            isOneEditAway= isReplace(s,t);
        }
        else if(s.length()<t.length()){
            isOneEditAway=isRemove(s,t);
        }
        else{
            isOneEditAway=isRemove(t,s);
        }

//        if(s.length()>t.length()){
//            isOneEditAway=isInsert(t,s);
//        }
        return isOneEditAway;

    }
    static boolean isReplace(String s,String t){
        int cnt=0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)!=t.charAt(i)){
                cnt++;
            }
            if(cnt>1){
                return false;
            }
            i++;
        }
        return true;
    }
    static boolean isRemove(String s,String t){
        int cnt=0;
        int i=0;
        int j=0;
        while(i<t.length() && j<s.length()){
            if(cnt==0){
                if(t.charAt(i)!=s.charAt(j)){
                    cnt++;
                    i++;
                    //j++;
                }
                else{
                    i++;
                    j++;
                }
            }
            else{
                if(t.charAt(i)!=s.charAt(j)){
                    return false;
                }
                else{
                    i++;
                    j++;
                }
            }
        }
        return true;

    }
//    static boolean isInsert(String s,String t){
//
//    }
}
