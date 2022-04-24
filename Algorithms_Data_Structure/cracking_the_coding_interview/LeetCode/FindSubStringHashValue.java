public class FindSubStringHashValue {
    int md=(int)1e9+7;
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        /*
            1.calculate hash value of k
            2.then move the string i=1 to i=n-1 remove i-1 and i then take the hashvalue
        */
        StringBuilder rsb=new StringBuilder();
        long hashSum=0;
        int n=s.length();
        for(int i=0;i<k;i++){
            int a=s.charAt(i)-'a'+1;
            hashSum+=getHashValue(a,power,i);
        }
        if((hashSum%modulo)==hashValue){
            String str=s.substring(0,k);
            rsb.append(str);
            return rsb.toString();
        }
        int j=0;
        int p=k-1;
        int cnt=0; // lee 0,1,2 // eet 0 //0,1,2 //etc//0,1,2
        for(int i=1;i<n;i++){
             cnt=0;
            hashSum=0;
            for( j=i;j<n && cnt<k && j+k<n;j++){
                int a=s.charAt(j)-'a'+1;
                hashSum+=getHashValue(a,power,cnt);
                cnt++;
            }
            if((hashSum%modulo)==hashValue){
                String str=s.substring(i,i+k);
                rsb.append(str);
                return rsb.toString();
            }
        }
        return rsb.toString();

    }
    public long getHashValue(int c,int p,int i) {
        long value = (long) ((c * Math.pow(p, i)));
        return value;
    }


    public static void main(String[] args) {
        FindSubStringHashValue obd=new FindSubStringHashValue();
        System.out.println(obd.subStrHash("xmmhdakfursinye",96,45,15,21));
    }
}
