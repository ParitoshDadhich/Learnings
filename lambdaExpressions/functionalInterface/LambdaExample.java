package FunctionalInterfaces;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LambdaExample {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        PS - we can still use lambda expression here
        even though myInterface contains implemented methods

        REASON
        MyInterface contains ONE UN-IMPLEMENTED method (ABSTRACT METHOD) - that is what is required to fulfill the criteria
        of using lambda expression.
        Interface must have one un-implemented method -> that can be used in lambda expresion;
         */
//        MyInterface myInterface = (String text) -> System.out.println(text);
//        OR
        MyInterface myInterface = (text) -> System.out.println(text);
        myInterface.printIt("Hello World");

        // we can still access other implemented methods of MyInterface
        myInterface.printUtf8To("Hello file", new FileOutputStream("data.txt"));

        // ACCESS STATIC METHODS IN MyInterface
        MyInterface.printItToSystemOut("Hello out");
    }
}
