import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Main {
    public static LocalDate today = LocalDate.now();
    public static LocalDate birthday;
    public static int count = 0;
    public static LocalDateTime javaBirthday;


    public static void main(String[] args) {
        System.out.println(collectBirthdays(1989, 03, 30));
        System.out.println(getPeriodFromBirthday());


    }

    public static String collectBirthdays(int year, int month, int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE");
        birthday = LocalDate.of(year, month, day);
        String text = "";
        do {
            //System.out.println(count + " - " + formatter.format(birthday));
            text = text + count + " - " + formatter.format(birthday) + System.lineSeparator();
            birthday = birthday.plusYears(1);
            count = count + 1;

        } while (birthday.isBefore(today));

        return text;
    }

    public static String getPeriodFromBirthday() {

        long timeFlowYears = System.currentTimeMillis() / 31536000000L;

        long timeFlowMonths = (System.currentTimeMillis() % 31536000000L) / 241920000;

        long timeFlowDays = ((System.currentTimeMillis() % 31536000000L) % 241920000) / 86400000;

        return ("years: " + timeFlowYears + " months: " + timeFlowMonths + " days: " + timeFlowDays);

    }

}
