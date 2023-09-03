import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda3_Streams {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // Stream: Filter
        Predicate<Integer> geradeZahl = (a) -> a % 2 == 0;
        List<Integer> ergebnis = numbers.stream().filter(geradeZahl).collect(Collectors.toList());
        System.out.println(ergebnis);

        // Stream: Filter
        ergebnis = numbers.stream().filter((a) -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(ergebnis);
    }
}
