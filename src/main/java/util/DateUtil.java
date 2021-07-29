package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Objects;

public class DateUtil {
    private static final DateTimeFormatter DATE_FORMATTER_SLASH = DateTimeFormatter.ofPattern("dd/MM/yy");
    private static final DateTimeFormatter DATE_FORMATTER_DOT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter DATE_FORMATTER_PARSE = new DateTimeFormatterBuilder()
            .appendPattern("[d/MM/]" + "[d.MM.]")
            .optionalStart().appendPattern("yyyy").optionalEnd()
            .optionalStart().appendValueReduced(ChronoField.YEAR, 2, 2, 1922)
            .optionalEnd().toFormatter();

    public static String dateToStringSlash(LocalDate date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.format(DATE_FORMATTER_SLASH);
    }

    public static String dateToString(LocalDate date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.format(DATE_FORMATTER_DOT);
    }

    public static LocalDate parse(String date) {
        if (checkDate(date)) {
            return LocalDate.parse(date, DATE_FORMATTER_PARSE);
        } else {
            System.out.println("Invalid input string date " + date);
        }
        return null;
    }

    private static boolean checkDate(String date) {
        return date.matches("^\\d{1,2}(/|\\.)\\d{2}(/|\\.)\\d{2,4}$"); //should be better
    }
}