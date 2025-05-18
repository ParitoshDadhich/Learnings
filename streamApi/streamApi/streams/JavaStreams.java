package streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
note
You can’t consume a stream twice because it's designed to avoid unintended re-use of resources, support lazy execution, and to simplify and optimise stream processing.
 */
public class JavaStreams {
    public static void main(String[] args) throws IOException {
        // 1. Integer Stream
        IntStream
                .range(1, 10) // intermediate operations
                .forEach(System.out::print);    // terminal operation

        System.out.println();
        System.out.println();


        // 2. Integer stream with skip
        IntStream
                .range(1, 10)
                .skip(5) // skip first 5 elements
                .forEach(x -> System.out.print(x));   // x is the parameter that is passed - which is the series of integers
        System.out.println();
        System.out.println();

        // 3. Integer stream with sum
        System.out.print(
                IntStream
                        .range(1, 5)
                        .sum()
        );
        System.out.println();
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        // Stream.of - use to create stream out of integer, float, strings, objects etc
        Stream.of("Ava", "Ameer", "Anant")
                .sorted()   // can also pass custom comparator as well
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        // 5. Stream.of, custom sorted and findFirst
        // Stream.of - use to create stream out of integer, float, strings, objects etc
        Stream.of("Ava", "Ameer", "Anant")
                .sorted((a, b) -> b.compareTo(a))   // can also pass custom comparator as well
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        // 6. Stream from Array, sort, filter and print
        // We could have also used Stream.of in order to create a stream
        String[] names = {
                "Aarav", "Anika", "Ayaan", // A
                "Bhavya", "Bhuvan",        // B
                "Chirag", "Charvi",        // C
                "Dev", "Diya",             // D
                "Esha", "Eshan",           // E
                "Farhan", "Fatima",        // F
                "Gaurav", "Gita",          // G
                "Harsh", "Heena",          // H
                "Ishaan", "Ira"            // I
        };
        Arrays.stream(names)
                .filter(x -> x.startsWith("A"))
                .sorted()
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println();

        // 7. avarage of squares of an int array
        /*
        Stream map(Function mapper) returns a stream consisting of the
        results of applying the given function to the elements of this stream.
         */
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x*x) // mapping each item with its square
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        // 8. Stream from List, filter and print
        List<String> people = Arrays.asList(names);
        people
                .stream()
                .map(String::toLowerCase)
                .sorted()
                .filter(x->x.startsWith("a"))
                .forEach(x-> System.out.print(x + " "));

        System.out.println();
        System.out.println();

        // 9. Stream rows from text file, sort, filter and print
        Stream<String> bands = Files.lines(Paths.get("C:\\Users\\Paritosh Dadhich\\eclipse-workspace\\Java8CrashCourse\\src\\main\\java\\streams\\bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close(); // closing to prevent memory link
        System.out.println();
        System.out.println();

        // 10. Stream rows from text file and save to list
        List<String> bands2 = Files.lines(Paths.get("C:\\Users\\Paritosh Dadhich\\eclipse-workspace\\Java8CrashCourse\\src\\main\\java\\streams\\bands.txt"))
                .map(String::toLowerCase)
                .filter(x -> x.contains("the"))
                .collect(Collectors.toList()); // collect is a collector to collect streams
        bands2.forEach(x -> System.out.println(x));
        System.out.println();
        System.out.println();

        // 11. Stream rows from CSV file and count
        Stream<String> rows = Files.lines(Paths.get("C:\\Users\\Paritosh Dadhich\\eclipse-workspace\\Java8CrashCourse\\src\\main\\java\\streams\\data.txt"));
        int goodRowCount = (int)rows
                .map(x -> x.split(","))
                .filter(x -> x.length==4)
                .count();
        System.out.println("Good rows " + goodRowCount);


        List<String[]> goodRows = Files.lines(Paths.get("C:\\Users\\Paritosh Dadhich\\eclipse-workspace\\Java8CrashCourse\\src\\main\\java\\streams\\data.txt"))
                .map(x -> x.split(","))
                .filter(x -> x.length==4)
                .collect(Collectors.toList());
        goodRows.forEach(x-> System.out.println(Arrays.toString(x)));
        System.out.println();
        System.out.println();

        // print individual values
        goodRows.forEach(x ->{
            for(String value : x){
                System.out.print(value + " ");
            }
            System.out.println();
        });

        System.out.println();
        System.out.println();

        // 12. Stream rows from csv file, parse data from rows
        Files.lines(Paths.get("C:\\Users\\Paritosh Dadhich\\eclipse-workspace\\Java8CrashCourse\\src\\main\\java\\streams\\data.txt"))
                .map(x->x.split(","))
                .filter(x->x.length==4)
                .forEach(x-> System.out.println(x[0] + " " + x[1] + " " + x[2] + " " + x[3]));
        System.out.println();
        System.out.println();

        // 13. Stream rows from CSV file, store fields in HashMap
        Stream<String> row3 = Files.lines(Paths.get("C:\\Users\\Paritosh Dadhich\\eclipse-workspace\\Java8CrashCourse\\src\\main\\java\\streams\\data.txt"));
        Map<String, String[]> map = new HashMap<>();
        map = row3
                .map(x -> x.split(","))
                .filter(x->x.length==4)
                .collect(Collectors.toMap(
                        x->x[0],
                        x->new String[]{x[1], x[2],x[3]}
                ));
        row3.close();
        for(String key: map.keySet()){
            System.out.println(key + ": " + Arrays.toString(map.get(key)));
        }
        System.out.println();
        System.out.println();

        // 14. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a+b);
        System.out.println("Total " + total);
        System.out.println();

        // 15. Reduction - summary statistics
        // works only with integer
        IntSummaryStatistics summaryStatistics = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summaryStatistics);
    }
}
