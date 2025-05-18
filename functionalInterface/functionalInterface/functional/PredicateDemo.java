package functionalInterface.functional;
import java.util.function.Predicate;
/*
Interface Predicate<T>
accepts an input - T
return bool

method - test(T t)
 */

class PredicateImpl implements Predicate<String>{

    @Override
    public boolean test(String s) {
        return s.isEmpty();
    }
}

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new PredicateImpl();
        System.out.println("Check String empty using traditional way " + predicate.test("Paritosh"));

        Predicate<String> predicateLambda = (str) -> str.isEmpty();
        System.out.println("Check String empty using traditional way " + predicateLambda.test(""));
    }
}
