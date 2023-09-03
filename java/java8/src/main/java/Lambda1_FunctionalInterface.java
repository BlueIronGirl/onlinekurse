import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda1_FunctionalInterface {
    private static void test() {
        System.out.println("Test");
    }

    public static void main(String[] args) {
        AddInterface addInterface = (a, b) -> (a + b);
        System.out.println(addInterface.add(1, 2));

        HelloInterface helloInterface = () -> System.out.println("Hello");
        helloInterface.display();

        // Method-Reference: static-Method in Klasse
        HelloInterface methodReference = Lambda1_FunctionalInterface::test;
        methodReference.display();

        // Method-Reference: static-Method in Interface
        HelloInterface staticReference = HelloInterface::myUtilityMethod;
        staticReference.display();
    }
}

@FunctionalInterface
interface AddInterface {
    int add(int a, int b);
}

@FunctionalInterface
interface HelloInterface {
    void display();

    static void myUtilityMethod() {
        System.out.println("Test");
    }
}
