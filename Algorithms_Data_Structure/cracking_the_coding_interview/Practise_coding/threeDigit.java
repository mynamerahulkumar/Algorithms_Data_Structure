public class threeDigit {
    public int solution(int N, int K) {
        // write your code in Java SE 8
        StringBuilder sb=new StringBuilder();
        int r=100;
        while(N>0){
            int num=N/r;
            int rem=9-num;
          //  System.out.println(num+"-"+rem);
            if(K>=rem){
                num=num+rem;
                sb.append(num);
                K=K-rem;
            }
            else{
                num=num+K;
                K=0;
                sb.append(num);
            }
            N=N%r;
            r=r/10;
           // System.out.println(num+"-"+N+"-"+K+"-"+sb.toString());
        }
        Integer value=Integer.valueOf(sb.toString());
        return value;

    }

    public static void main(String[] args) {
        threeDigit ob=new threeDigit();
        System.out.println(ob.solution(285,20));
    }
}
