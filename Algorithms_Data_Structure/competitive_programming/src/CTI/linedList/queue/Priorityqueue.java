package CTI.linedList.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<String> pq=new PriorityQueue<>();
        pq.add("cat");
        pq.add("afa");
        pq.add("dog");
        Iterator it=pq.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
