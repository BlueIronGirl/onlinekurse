import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsEnhancements {
    private static final List<Integer> numbersList = Arrays.asList(50, 60, 80, 90, 40, 30);

    public static void main(String[] args) {
        List<Integer> takeWhileList = numbersList.stream().takeWhile(i -> i < 80).collect(Collectors.toList());
        System.out.println(takeWhileList);

        List<Integer> dropWhileList = numbersList.stream().dropWhile(i -> i < 80).collect(Collectors.toList());
        System.out.println(dropWhileList);

        List<Integer> nullList = null;
        List<List<Integer>> tempList = Stream.ofNullable(nullList).collect(Collectors.toList());
        System.out.println(tempList);
    }
}
