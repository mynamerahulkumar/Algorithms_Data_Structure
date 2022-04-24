import java.util.Arrays;
import java.util.Comparator;

class Animal{
    void bark(){
        System.out.println("Barking");
    }
}
public class Anonmyous {
    private static String[] reverseString(String[] names){
        Comparator<String> revComparator=new Comparator<String>(){
            //anonmyous class

            @Override
            public int compare(String s1,String s2){
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(names,revComparator);
        return  names;
    }

    public static void main(String[] args) {
        String[]names={"1423","24","1414"};
        names=Anonmyous.reverseString(names);
        System.out.println(Arrays.toString(names));
    }

}
