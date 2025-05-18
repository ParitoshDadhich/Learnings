package VariableCaptureWithinLambdaExpressions;

import FunctionalInterfaces.MyInterface;

public class LambdaExpression {
    static String thirdText = "Heyyyy";
    String fourthText = "hiiii";
    public static void main(String[] args) {
        // we can access variables that are declared outside
        // lambda expression IF AND ONLY IF -
        // VARIABLES ARE FINAL OR EFFECTIVELY FINAL(DON'T CHANGE THEIR VALUES)
        // NOTE - Rule for effectively final ONLY works for local variable (variables that are declared within the method)
        String otherText = "Hello there!";
        MyInterface myInterface = (text) -> {
            LambdaExpression lambdaExpression = new LambdaExpression();

            System.out.println(otherText);
            System.out.println(thirdText);
            System.out.println(lambdaExpression.fourthText);
        };

        System.out.println("BEFORE");
        myInterface.printIt("hello");
        thirdText = "heyyy thereeee";
        System.out.println("AFTER\n");
        myInterface.printIt("testing");
    }
}
