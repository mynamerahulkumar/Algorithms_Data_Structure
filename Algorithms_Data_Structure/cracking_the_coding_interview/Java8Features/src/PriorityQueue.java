import java.util.Comparator;

public class PriorityQueue {
    public static void main(String[] args) {
        java.util.PriorityQueue pq=new java.util.PriorityQueue();
        pq.offer(2);
        pq.offer(4);
        pq.offer(1);
        Comparator reverseComparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer param1, Integer param2) {
                return param2-param1;
            }
        };
        System.out.println(pq);
    }
}
