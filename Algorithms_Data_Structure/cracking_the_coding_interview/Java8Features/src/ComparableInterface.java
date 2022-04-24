import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class ComparableInterface  implements Comparable<ComparableInterface>{
    int run;
    String name;
    ComparableInterface(int run,String name){
        this.run=run;
        this.name=name;
    }

    @Override
    public int compareTo(ComparableInterface that){
        if(this.run> that.run){
            return -1;
        }
        else if(this.run<that.run){
            return 1;
        }
        return 0;
    }
    public static void main(String[]args){
        List<ComparableInterface>list=new ArrayList<>();
        for(int i=0;i<5;i++) {
            ComparableInterface obj1 = new ComparableInterface(i+2, "23423"+i);
            list.add(obj1);
        }
        ComparableInterface obj2 = new ComparableInterface(0, "23423");
        list.add(obj2);
        Collections.sort(list);
        list.stream().forEach(x-> System.out.println(x.name+"-"+x.run));

    }
}
