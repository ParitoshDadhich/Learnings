package functionalInterface;

@FunctionalInterface
public interface MyFunctionalInterface {
    public void print(String msg);

    default void al(){
        System.out.println("Default methods");
    }

    static void m2(){
        System.out.println("Static method");
    }
}
