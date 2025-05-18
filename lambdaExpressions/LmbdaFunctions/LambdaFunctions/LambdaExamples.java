package LambdaFunctions;

import java.util.Comparator;
/*
Java lambdas require a functional interface (only one abstract method).

You can't define multiple apply() methods in a single interface and expect lambda expressions to work.

Define separate interfaces for different argument types/counts.
 */
public class LambdaExamples {
    public static void main(String[] args) {
        // ANONOMOUS INTERFACE IMPL OF STRING COMPARATOR
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        int compare = stringComparator.compare("hello", "world");
        System.out.println(compare);

//        WITH LAMBDA EXPRESSION
        /*
        Java lambda expression has to implement SINGLE METHOD INTERFACE
         */
        Comparator<String> stringComparatorLambda =
                (String o1, String o2) -> {return o1.compareTo(o2);};

        int compare2 = stringComparatorLambda.compare("hello", "world");
        System.out.println(compare2);

        // SIMPLIFIED LAMBDA EXPRESSION FROM JAVA8 ONWARDS
        /*
        in case of single statements inside the body {}
        we need not to use return keyword and use curly brackets
         */
        Comparator<String> stringComparatorLambdaSimplified =
                (o1, o2) -> o1.compareTo(o2);
        int compare3 = stringComparatorLambdaSimplified.compare("hello", "world");
        System.out.println(compare3);
    }
}
