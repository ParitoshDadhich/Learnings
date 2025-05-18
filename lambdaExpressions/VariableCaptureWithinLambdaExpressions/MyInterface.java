package VariableCaptureWithinLambdaExpressions;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public interface MyInterface {
    void printIt(String text);

    default public void printUtf8To(String text, OutputStream outputStream){
        try{
            outputStream.write(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static void printItToSystemOut(String text){
        System.out.println(text);
    }
}
