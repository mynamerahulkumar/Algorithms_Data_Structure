public class count_number_of_ways {
    static  int printCountDP(int dist){
        int []count=new int[dist+1];
        count[0]=1;
        if(dist>=1){
            count[1]=1;
        }
        if(dist>=2){
            count[2]=2;
        }
        for (int i=3;i<=dist;i++){
            count[i]=count[i-1]+count[i-2]+count[i-3];
        }
        return count[dist];
    }
    public static void main(String[] args) {
        int dist = 4;
        System.out.println(printCountDP(dist));
    }
}
