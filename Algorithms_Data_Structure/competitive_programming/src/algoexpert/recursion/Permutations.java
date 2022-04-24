package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {    public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
    ArrayList<List<Integer>> permutations=new ArrayList<List<Integer>>();
    permutationHelper(0,array,permutations);
    return permutations ;
}
    public static void permutationHelper(int i,List<Integer> array,
                                         ArrayList<List<Integer>>permutations ){
        if(i==array.size()-1){
            permutations.add(new ArrayList<Integer>(array));
        }
        else{
            for(int j=i;j<array.size();j++){
                swap(array,i,j);
                permutationHelper(i+1,array,permutations);
                swap(array,i,j);
            }
        }
    }
    public static void swap(List<Integer>array,int i,int j){
        int temp=array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);

    }
}
