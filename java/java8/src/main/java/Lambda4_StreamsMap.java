import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda4_StreamsMap {
    public static void main(String[] args) {
        List<String> javaVersionList = new ArrayList<>();
        javaVersionList.add("Java 7");
        javaVersionList.add("Java 8");
        javaVersionList.add("Java 9");
        javaVersionList.add("Java 10");
        javaVersionList.add("Java 11");
        javaVersionList.add("Java 12");

        // Map -> 1 Input 1 Output
        List<String> javaVersionUppercase = javaVersionList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(javaVersionUppercase);

        // Flatmap -> 1 Input N Outputs
        List<String> javaVersionUppercaseAndJFF = javaVersionList.stream()
                .flatMap(version -> Stream.of(version.toUpperCase(), version.toLowerCase(), version.concat(" JFF")))
                .collect(Collectors.toList());
        System.out.println(javaVersionUppercaseAndJFF);
    }
}
