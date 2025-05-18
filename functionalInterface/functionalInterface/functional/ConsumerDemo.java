package functionalInterface.functional;
/*
Interface Consumer<T>
Accepts an input - T
Returns no output

method - accept(T t)
 */

import java.util.function.Consumer;

// TRADITIONAL WAY TO IMPLEMENT CONSUMER FUNCTIONAL INTERFACE
class ConsumerImpl implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println("Printing " + s);
    }
}

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("via traditional way");

        // IMPLEMENTING CONSUMER FUNCTIONAL INTERFACE USING LAMBDA EXPRESSION
        Consumer<String> consumerLambda = (str) -> System.out.println("Printing " + str);
        consumerLambda.accept("via lambda expression");
    }
}
