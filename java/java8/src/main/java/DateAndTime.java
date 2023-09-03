import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(nowDate);
        System.out.println(now);

        // Date-Details
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfMonth() + "/" + now.getMonthValue() + "/" + now.getDayOfYear());

        // Time-Details
        System.out.println(now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());

        // Specific Date
        LocalDate myBirthday = LocalDate.of(1996, 6, 13);
        System.out.println(myBirthday);

        // Duration
        Instant startTime = Instant.now();
        warte(3);
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Time taken: " + duration.toSeconds());

        // AfterDate, BeforeDate, EqualDate
        nowDate = LocalDate.now();
        LocalDate beforeDate = LocalDate.of(2019, 1, 1);
        LocalDate beforeDate2 = LocalDate.of(2019, 1, 1);
        System.out.println(nowDate.isAfter(beforeDate));
        System.out.println(nowDate.isBefore(beforeDate));
        System.out.println(beforeDate2.isEqual(beforeDate));

        // PlusDays, MinusDays
        LocalDate plusDay = LocalDate.of(2022, 10, 30);
        System.out.println(plusDay.plusDays(2));
        System.out.println(plusDay.minusDays(3));

        // Passwort abgelaufen?
        isPasswordExpired();
    }

    private static void isPasswordExpired() {
        LocalDate currentDate = LocalDate.now();
        LocalDate passwortSetOnDate = LocalDate.of(2019, 1, 1);
        long passwordExpiryDays = 30;
        if (currentDate.isAfter(passwortSetOnDate.plusDays(passwordExpiryDays))) {
            System.out.println("Your Password has expired");
        }
    }

    public static void warte(int iSeconds) {
        try {
            Thread.sleep(iSeconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
