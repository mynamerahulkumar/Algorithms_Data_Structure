import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximumEvenSplit {
    public List<Long> maximumEvenSplit(long finalSum) {
        // 28 ->(2,26)
        //26->(4,22)
        //22->(6,16) // 16->(8,8) //break
        //16->(10,6)

        //12->(2,10)
        //10->(4,6)
        //6->(6,0)
        TreeMap<Long,Long> tmap=new TreeMap<>();
        List<Long>resList=new ArrayList<>();
        long r=2;
        if(finalSum%2!=0){
            return resList;
        }
        if(finalSum==2){
            resList.add(0L);
            resList.add(1L);
            return resList;
        }
        while(true){
            if(tmap.containsKey(r)){
                break;
            }
            else if(r==finalSum){
                break;
            }
            else{
                finalSum=finalSum-r;
                if(finalSum<=r) break;
                tmap.put(r,finalSum);
                r=r+2;
            }
        }
        long key=0;
        for(Map.Entry<Long,Long>element:tmap.entrySet()){
            key=element.getKey();
            resList.add(key);
        }
        long lastValue=tmap.get(key);
        resList.add(lastValue);
        return resList;
    }

    public static void main(String[] args) {
        MaximumEvenSplit obj=new MaximumEvenSplit();
        System.out.println(obj.maximumEvenSplit(4));

    }
}
