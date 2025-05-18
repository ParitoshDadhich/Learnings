package functionalInterface.functional;
/*
Interface Supplier<T>
Doesn't accept any input
Returns an output - T

method - get()
 */

import java.time.LocalDateTime;
import java.util.function.Supplier;

class SupplierImpl implements Supplier<LocalDateTime>{

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<LocalDateTime> supplier = new SupplierImpl();
        System.out.println("From traditional way " + supplier.get());

        Supplier<LocalDateTime> supplierLambda = () -> LocalDateTime.now();
        System.out.println("From Lambda expression " + supplierLambda.get());
    }
}
