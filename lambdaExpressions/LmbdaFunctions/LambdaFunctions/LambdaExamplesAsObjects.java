package LambdaFunctions;/*
Lambda expression acts like an object so we can pass it around just like an normal object;
Lambda expressions are objects just like anonomyous implementation of interface are.
 */

public class LambdaExamplesAsObjects {
    public static void main(String[] args) {
        MyFunctionMultipleParams myFunction = (a, b, c) -> System.out.println(a + b + c);

        // passing lambda expression as an object
        MyFunctionMultipleParams myFunction1 = myFunction;
        myFunction1.apply("1", "2", "3");
    }
}
