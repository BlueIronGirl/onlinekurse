import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatting {
    public static void main(String[] args) {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance();
        System.out.println(fmt.format(1000));

        NumberFormat fmt2 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(fmt2.format(1000));

        NumberFormat fmt3 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(fmt3.format(1000));
    }
}
