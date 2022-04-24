import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        // 1 Integer stream
        IntStream.range(1,10).forEach(System.out::print);

        // 2. Integer stream with skip first 5 element
        IntStream.range(1,10).skip(5).forEach(x-> System.out.println(x));// here x is param from range

        //3 Integer stream with sum
        System.out.println(IntStream.range(1,5).sum());

        //4. Stream of sorted and find first
        Stream.of("Ava","Aneri","Alberto")
                .sorted()
                .findFirst().ifPresent(System.out::println);
        //5.Stream of Array,filter,sort and print
        String[]Arr={"Abc","sdc","sde","bce"};
        Arrays.stream(Arr)
                .filter(x->x.startsWith("s"))
                .sorted()
                .forEach(System.out::println);
        // 6. Square the integer and took the average
        Arrays.stream(new int[]{2,3,4,6})
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println);

        //7.Stream from a list filter and print
        List<String> people=Arrays.asList("Abc","fgdg","asgg","sgg");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x->x.startsWith("a"))
                .forEach(System.out::println);
        //9 stream rows from text file and save to list
        List<String>band2= null;
        try {
            band2 = Files.lines(Paths.get("/Users/rahul/Documents/GitHub/Algorithms/cracking_the_coding_interview/Java8Features/src/Resources/band.txt"))
                    .filter(x->x.contains("jit"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        band2.forEach(x-> System.out.println(x));
    }
}
