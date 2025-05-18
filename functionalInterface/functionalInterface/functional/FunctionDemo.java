package functionalInterface.functional;

import java.util.function.Function;
/*
Interface Function<T,R>
Accepts a single argument - T
returns an output - R

method - apply(T t)
 */


// TRADITIONAL WAY TO IMPLEMENT FUNCTION INTERFACE
// TAKING STRING - INPUT
// INTEGER - OUTPUT
class FunctionImpl implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

public class FunctionDemo {
    public static void main(String[] args) {
        // TRADITIONAL WAY
        Function<String, Integer> function = new FunctionImpl();
        System.out.println(function.apply("Paritosh Dadhich"));

        // IMPLEMENT USING LAMBDA EXPRESSION
        Function<String, Integer> functionByLambda = (str) -> str.length();
        System.out.println(functionByLambda.apply("Paritosh Dadhich"));
    }
}
