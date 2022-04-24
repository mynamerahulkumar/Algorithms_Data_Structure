import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
    /*
  https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/

  Create a recursive function that takes the following parameters, input array, the current index, the output array, or current subset, if all the subsets need to be stored then a vector of the array is needed if the subsets need to be printed only then this space can be ignored.
if the current index is equal to the size of the array, then print the subset or output array or insert the output array into the vector of arrays (or vectors) and return.
There are exactly two choices for very index.
Ignore the current element and call the recursive function with the current subset and next index, i.e i + 1.
Insert the current element in the subset and call the recursive function with the current subset and next index, i.e i + 1.

*/
    public int[][] subsets(int[] A) {
        Arrays.sort(A);
        ArrayList<ArrayList<Integer>> subset=new ArrayList<>();
        ArrayList<Integer>output=new ArrayList<>();
        findSubset(subset,A,0,output);
        int[][]res;
        int size=subset.size();
        // sort the subset using collections

        res=new int[size][];
        Collections.sort(subset,(o1, o2)->{
            int n=Math.min(o1.size(),o2.size());
            for(int i=0;i<n;i++){
                if(o1.get(i)==o2.get(i)){
                    continue; // if all element are same then continue
                }
                else{ //2,3,4 // 3,4,5
                    return o1.get(i)-o2.get(i); // if it is negative then first parameter inseted
                }
            }
            return o1.size()-o2.size();//2,3,4 // 2,3,4,5 return o1
        });
        // store in two 2d ArrayList
        res=new int[size][];
        for(int i=0;i<size;i++){
            res[i]=new int[subset.get(i).size()];
            for(int j=0;j<subset.get(i).size();j++){
                res[i][j]=subset.get(i).get(j);
            }
        }
        return res;


    }
    public void findSubset(ArrayList<ArrayList<Integer>> offset,int[]A,int index,ArrayList<Integer>output){
        if(index==A.length){
            offset.add(output);
            return ;
        }
        //ignore the current element and increase the index;
        findSubset(offset,A,index+1,new ArrayList<Integer>(output));
        //add the current element in output and increase the index;
        output.add(A[index]);
        findSubset(offset,A,index+1,new ArrayList<Integer>(output));

    }

    public static void main(String[] args) {
        Subset subset=new Subset();
        int[]A={};
        System.out.println();
    }

}
