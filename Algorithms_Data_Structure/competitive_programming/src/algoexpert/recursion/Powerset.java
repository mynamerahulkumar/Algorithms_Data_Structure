package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class Powerset {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> permutations= new ArrayList<List<Integer>>();
        getPermutations(array,new ArrayList<Integer>(),permutations);
        return permutations;
    }
    public static void getPermutations(List<Integer> array,List<Integer> currentPermutation,
                                       List<List<Integer>> permutation){
        if(currentPermutation.size()>0){
            permutation.add(currentPermutation);
        }

            for(int i=0;i<array.size();i++){
                List<Integer> newArray=new ArrayList<Integer>(array);
                newArray.remove(i);
                List<Integer> newPermutation=new ArrayList<Integer>(currentPermutation);
                newPermutation.add(array.get(i));
                getPermutations(newArray,newPermutation,permutation);
            }

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(getPermutations(arr));
    }
}
