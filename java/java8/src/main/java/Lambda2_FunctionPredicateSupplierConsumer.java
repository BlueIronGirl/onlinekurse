import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda2_FunctionPredicateSupplierConsumer {
    public static void main(String[] args) {
        // Function
        Function<Integer, Integer> functionQuare = a -> a * a;
        System.out.println(functionQuare.apply(2));

        // Function: andThen & compose
        Function<String, String> function1 = String::toUpperCase;
        Function<String, String> function2 = s -> s + " World";
        System.out.println(function2.andThen(function1).apply("Hello"));
        System.out.println(function1.compose(function2).apply("Hello"));

        // Predicate
        Predicate<Integer> greater = a -> a > 0;
        System.out.println(greater.test(1));

        // Supplier
        Supplier<Boolean> mySupplier = () -> true;
        System.out.println(mySupplier.get());

        // Consumer
        Consumer<String> consumer = a -> System.out.println(a.toUpperCase());
        consumer.accept("Test");
    }
}
