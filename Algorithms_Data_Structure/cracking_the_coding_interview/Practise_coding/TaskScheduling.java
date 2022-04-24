import java.util.ArrayList;

public class TaskScheduling {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int totalCycle=0;
        int n=A.size();
        for(int i=0;i<n;i++){
            int taskNo=B.get(i);
            int findIndexOfTask=0;
            // if task found in sequence

            if(A.size()>0 && A.get(0)==B.get(i)){
                totalCycle++;
                A.remove(0);
            }
            else if(A.size()==0){
                break;
            }
            else{
                int k=0;
                // find the task number index in A
                while(k<A.size() && A.get(k)!=B.get(i)){
                    k++;
                }
                int m=A.size();
                // find the task number index in A
                for(int j=0;j<k;j++){
                    A.add(m,A.get(j));
                    m++;
                   // totalCycle++;
                }
                // delete the task from beginning
                for(int j=0;j<=k && j<A.size();j++){
                    A.remove(0);
                    totalCycle++;
                }
            }
        }
        return totalCycle;
    }

    public static void main(String[] args) {
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(5);
        A.add(4);
        B.add(1);
        B.add(3);
        B.add(5);
        B.add(4);
        B.add(2);
        TaskScheduling t1=new TaskScheduling();
        System.out.println(t1.solve(A,B));
    }
}
