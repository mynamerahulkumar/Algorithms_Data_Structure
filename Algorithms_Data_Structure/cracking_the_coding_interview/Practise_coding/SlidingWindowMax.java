import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> list=new ArrayList<>();
        // use double ended queue
        /*
            Note :insert index in dq instead of elements
            1) while rear element <A[i] ->pop from rear end (multiples times)
            2)insert A[i] from rear
            3)if front element is outside the sliding window->dequeueFront
            4)Ans[i]=fron element
        */
        int n=A.size();
        Deque<Integer> dq=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        if(n==1){
            ans.add(A.get(0));
            return ans;
        }
        int max=0;
        for(int i=0;i<B;i++){
            if(A.get(i)>max){
                max=A.get(i);
            }
        }
        dq.addLast(max);
        ans.add(max);
        for(int i=1;i<=n-B;i++){
            while(!dq.isEmpty() && dq.pollLast()<A.get(i)){
                dq.removeLast();
            }
            dq.addLast(A.get(i));
            if(dq.size()==B){
                dq.removeFirst();
            }
            ans.add((dq.pollFirst()));
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);
        A.add(6);
        A.add(2);
        A.add(5);
        A.add(7);
        A.add(6);
        A.add(4);
        A.add(5);
        SlidingWindowMax slidingWindowMax=new SlidingWindowMax();
        ArrayList<Integer> list=slidingWindowMax.slidingMaximum(A,3);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+ " ");
        }
    }
}
