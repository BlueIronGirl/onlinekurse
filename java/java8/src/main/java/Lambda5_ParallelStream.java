import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda5_ParallelStream {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 70000; i++) {
            intList.add(i);
        }

        List<Integer> result = intList.parallelStream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
