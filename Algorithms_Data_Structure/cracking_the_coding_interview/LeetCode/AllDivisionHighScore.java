import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllDivisionHighScore {
    public List<Integer> maxScoreIndices(int[] nums) {
        int countZero=0;
        int countOne=0;
        Map<Integer,Integer> mapZero=new HashMap<>();
        Map<Integer,Integer>mapOne=new HashMap<>();
        int n=nums.length;
        //store the count of one and zero at each index
        for(int i=0;i<=n;i++){
            if(i==0){
                mapZero.put(i,countZero);
                continue;
            }
            else if(nums[i-1]==0){
                countZero++;
            }
            mapZero.put(i,countZero);
        }
        int k=0;
        int max=0; //update one count and get max value
        for(int i=n;i>=0;i--){
            if(i==n){
                mapOne.put(i,countOne);
                int zeroCnt=mapZero.get(i);
                int oneCnt=mapOne.get(i);
                max=Math.max(max,zeroCnt+oneCnt);
                continue;
            }
            else if(nums[i]==1){
                countOne++;

            }
            if(i!=n){
                mapOne.put(i,countOne);
                int zeroCnt=mapZero.get(i);
                int oneCnt=mapOne.get(i);
                max=Math.max(max,zeroCnt+oneCnt);
            }
        }
        // // get the max count from each index zero and one
        // int max=0;
        // for(int i=0;i<=n;i++){
        //     if(i==0){ // left is empty
        //         max=Math.max(max,(int)mapOne.get(i));
        //     }
        //     else if(i==n){ // right is empty;
        //         max=Math.max(max,(int)mapZero.get(i));
        //     }
        //     else{
        //         int zeroCnt=mapZero.get(i);
        //         int oneCnt=mapOne.get(i);
        //         max=Math.max(max,zeroCnt+oneCnt);
        //     }
        // }
        // get the index of max value
        ArrayList<Integer> resList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            int zeroCnt=mapZero.get(i);
            int oneCnt=mapOne.get(i);
            if(max==(zeroCnt+oneCnt)){
                resList.add(i);
            }
        }
        return resList;

    }

    public static void main(String[] args) {
        AllDivisionHighScore obj=new AllDivisionHighScore();
        int[]Arr={0,0,0};
       List<Integer>list= obj.maxScoreIndices(Arr);
       for(int i=0;i<list.size();i++){
           System.out.print(list.get(i));
       }
    }
}
