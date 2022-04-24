import java.util.ArrayList;

public class ConnectRope {
    /*
       1.use bottom up approach for insert
       2.Use top down approach for get min
   */
    ArrayList<Integer> heap=new ArrayList<>();
    int totalCost=0;
    public int solve(int[] A) {
        int n=A.length;
        for(int i=0;i<n;i++){
            insert(A[i]);
        }
        int result=0;
        while(true){
            if(heap.size()<=1){
//                if(heap.size()==0){
//                    break;
//                }
//                totalCost+=heap.get(0);
                break;
            }
            int min1=getMin();
            int min2=getMin();
            totalCost+=min1+min2;
            System.out.println(min1+"+"+min2+"="+(min2+min1)+"->"+totalCost);
            insert(min1+min2);
        }
        return totalCost;
    }
    public void insert(int num){
        if(heap.size()==0){
            heap.add(num);
            return;
        }
        /*
        1.Insert at the end length
        2.Traverse back to the parent check if parent is greater than child then swap
        parent=(i-1)/2
        */
        int n=heap.size();
        heap.add(num);
        int i=n;
        while(true){
            int parentIndex=(i-1)/2;
            if(parentIndex>=0){
                if(heap.get(parentIndex)>heap.get(i)){
                    swap(parentIndex,i);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
            i=parentIndex;
        }
    }
//    public int topHeapify(){
//
//    }
    public int getMin(){
        /*
            1.Min will be 0th element
            2.swap with last element to top and delete last element
            3.Heapify the root nodes by checking left or right nodes
            4.check min(left,right) then swap
            5.If any of child is empty then add it here add to left first (left complete)
        */
        if(heap.size()==0){
            return -1;
        }
        int min=heap.get(0);
        int n=heap.size();
        swap(0,n-1);
        heap.remove(n-1);// remove last element
        int i=0;
        n=heap.size();
        int lc=0;
        int rc=0;
        while(true){
            int fnd=0;
            if(2*i+1<n){
                lc=2*i+1;
                fnd=1;
            }
            else{
                break;
            }
            if(2*i+2<n){
                rc=2*i+2;
                fnd=2;
            }
            else if(fnd==0){
                break;
            }
            if(fnd==2 && heap.get(lc)<=heap.get(rc)){
                swap(i,lc);
                i=lc;
            }
            else if(fnd==2 && heap.get(lc)>heap.get(rc) ){
                swap(i,rc);
                i=rc;
            }
            else if(fnd==1 && heap.get(lc)<=heap.get(rc) ){
                swap(i,lc);
                i=lc;
            }
            else{
                i++;
            }
        }
        return min;
    }
    public void swap(int i,int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    public static void main(String[] args) {
        int[]A={5, 17, 100, 11};
        ConnectRope obj=new ConnectRope();
        System.out.println(obj.solve(A));
    }
}
