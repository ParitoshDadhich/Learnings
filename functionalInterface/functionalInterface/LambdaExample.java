package functionalInterface;

@FunctionalInterface
interface Shape{
    void draw();
}

// TRADITIONAL WAY TO IMPLEMENT INTERFACE
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("rectangle draw method");
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        // IMPLEMENT INTERFACE USING LAMBDA EXPRESSION
        Shape rectangle = () -> System.out.println("rectangle draw method using lambda");
        rectangle.draw();
    }
}
