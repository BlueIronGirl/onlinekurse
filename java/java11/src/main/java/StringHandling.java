import java.util.stream.Stream;

public class StringHandling {
    public static void main(String[] args) {
        // Repeat
        String javaVersion = "Java11\n";
        System.out.println(javaVersion.repeat(3));

        // IsBlank
        String str = "";
        System.out.println(str.isBlank());
        System.out.println("   ".isBlank());

        // Lines
        String lines = "Java11\nJava10\nJava9\nJava8";
        Stream<String> streamLines = lines.lines();
        streamLines.forEach(System.out::println);

        // Strip
        String javaVersionStrip = " Java 11 ";
        System.out.println(javaVersionStrip.strip());
        System.out.println(javaVersionStrip.stripTrailing());
        System.out.println(javaVersionStrip.stripLeading());
    }
}
