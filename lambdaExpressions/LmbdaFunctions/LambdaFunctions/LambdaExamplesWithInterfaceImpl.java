package LambdaFunctions;

/*
Java lambdas require a functional interface (only one abstract method).

You can't define multiple apply() methods in a single interface and expect lambda expressions to work.

Define separate interfaces for different argument types/counts.
 */
public class LambdaExamplesWithInterfaceImpl {
    public static void main(String[] args) {
        // here I did not mention any method parameters because method doesn't accept any params
        MyFunctionZeroParams myFunction = () -> System.out.println("Hello world");
        myFunction.apply();

//        LambdaFunctions.MyFunctionOneParams myFunction1 = (abc) -> System.out.println(abc);
        //  OR -> because method only accepts single param
        MyFunctionOneParams myFunction1 = abc -> System.out.println(abc);
        myFunction1.apply("Hello World");

        // WITH MULTIPLE PARAMS
        MyFunctionMultipleParams myFunction2 = (o1, o2, o3) -> System.out.println(o1 + o2 + o3);
        myFunction2.apply("1", "2", "3");

        MyFunctionMultipleParams myFunction3 = (o1, o2, o3) -> {
            String concat = o1 + o2 + o3;
            System.out.println(concat);
        };
        myFunction3.apply("Hello ", "World ", " Coders");

        // WHEN LAMBDA FUNCTION RETURNS
        MyFunctionReturns myFunction4 = (a, b, c) -> a + b + c;
        System.out.println(myFunction4.apply(1, 2, 3));

        myFunction4 = (a, b, c) -> {
            return a * b * c;
        };
        System.out.println(myFunction4.apply(1, 2, 3));
    }
}
