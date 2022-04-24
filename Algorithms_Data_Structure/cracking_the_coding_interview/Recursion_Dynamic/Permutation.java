import java.util.ArrayList;

public class Permutation {
    ArrayList<ArrayList<Integer>>result=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer>arr=new ArrayList<>();
        int N=A.size();
        makeallPermutation(A,arr,0,N);
        return result;
    }
    public void makeallPermutation(ArrayList<Integer>A,ArrayList<Integer>arr,int i,int N){
        if(arr.size()==N){
            result.add(arr);
            //arr.clear();
            return ;
        }
        if(i>=N) return;
        arr.add(A.get(i));
        makeallPermutation(A,arr,i+1,N);
        arr.remove(arr.size()-1);
        makeallPermutation(A,arr,i+1,N);

    }

    public static void main(String[] args) {
        ArrayList<Integer>inp=new ArrayList<>();
        inp.add(1);
        inp.add(2);
        inp.add(3);
        Permutation permutation=new Permutation();
        permutation.permute(inp);
    }
}
