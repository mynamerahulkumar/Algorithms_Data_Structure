import java.util.ArrayList;
import java.util.List;

public class Triangle{
    static class Solution {
        public int minimumTotal(List<List<Integer>> a) {
            int n=a.size();
            int result=0;
            if(n==1){
                result=Integer.MAX_VALUE;
                for(int i=0;i<a.get(0).size();i++){
                    if(a.get(0).get(i)<result){
                        result=a.get(0).get(i);
                    }
                }
                return result;
            }
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<a.get(i).size();j++){
                    int down=a.get(i+1).get(j);
                    int diagonal=a.get(i+1).get(j+1);
                    int s=a.get(i).get(j)+Math.min(down,diagonal);
                    a.get(i).set(j,s);
                }
            }
            result=a.get(0).get(0);
            return result;

        }
        public static  void fun(){

        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
//        ArrayList<ArrayList<Integer>> list=[[2],[3,4],[6,5,7],[4,1,8,3]];
//        solution.minimumTotal()
    }
}
