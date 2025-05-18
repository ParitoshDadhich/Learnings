package LambdaFunctions;/*
Java lambdas require a functional interface (only one abstract method).

You can't define multiple apply() methods in a single interface and expect lambda expressions to work.

Define separate interfaces for different argument types/counts.
 */

public interface MyFunctionZeroParams {
    public void apply();
//    public void apply(String param1);
//    public void apply(String param1, String param2);

}
