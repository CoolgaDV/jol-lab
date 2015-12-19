package cdv.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.util.VMSupport;

/**
 * Utility class to introspect classes and instances
 *
 * @author Dmitry Coolga
 *         19.12.2015
 */
public class Lab {

    public static void main(String[] args) throws Exception {
        printVirtualMachineDetails();
        // Specify classes and instances you'd like to introspect
        printClassDetails(String.class);
        printInstanceSize("Hello, world !!!");
    }

    private static void printVirtualMachineDetails() {
        println(VMSupport.vmDetails());
    }

    private static void printClassDetails(Class<?> cls) {
        println(ClassLayout.parseClass(cls).toPrintable());
    }

    private static void printInstanceSize(Object instance) {
        println("Instance size is: " + GraphLayout.parseInstance(instance).totalSize());
    }

    private static void println(Object argument) {
        System.out.println(argument);
    }

    /**
     * Disables instantiation for utility class
     */
    private Lab() { }
}
