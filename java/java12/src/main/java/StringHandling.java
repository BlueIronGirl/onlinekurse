public class StringHandling {
    public static void main(String[] args) {
        // Indent
        String text = "Learn Java Straightforward \n Join Java Fast Forward";
        System.out.println(text.indent(3));
        System.out.println(text.indent(5));

        // Transform
        String text2 = "Java".transform(str -> str + " Fast Forward");
        System.out.println(text2);
    }
}
