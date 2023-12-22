package org.example;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/11/7 下午8:47
 */
import java.lang.instrument.Instrumentation;

public class ObjectSizeMeasurement {
    public static void premain(String args, Instrumentation inst) {
        // This method is automatically called when the Java Virtual Machine is started with the -javaagent option
        // You can access the Instrumentation instance here
        instrumentation = inst;
    }

    private static Instrumentation instrumentation;

    public static long getObjectSize(Object obj) {
        if (instrumentation == null) {
            throw new IllegalStateException("Instrumentation not available");
        }
        return instrumentation.getObjectSize(obj);
    }

    public static void main(String[] args) {
        // Create an example object (e.g., a String)
        String exampleString = "Hello, World!";

        // Measure the size of the object using Instrumentation
        long size = getObjectSize(exampleString);

        System.out.println("Size of the object: " + size + " bytes");
    }
}

