import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		DateTimeFormatter DMform = DateTimeFormatter.ofPattern("d MMM", Locale.FRENCH);
		String dayMonth = dateTime.format(DMform);
		int year = dateTime.getYear();
		int hour = dateTime.getHour();
		int minute = dateTime.getMinute();
		int second = dateTime.getSecond();
		return "Le " + dayMonth + " de l'an " + year + " à " + hour + "h" + minute + "m " + "et " + second + "s";
	}

    public static String formatSimple(LocalDate date) {
        if (date == null) {
			return null;
		}
		DateTimeFormatter form = DateTimeFormatter.ofPattern("MMMM d yy", new Locale("it"));
		return date.format(form);
	}

    public static String formatIso(LocalTime time) {
        if (time == null) {
			return null;
		}
		if (time.getNano() == 0) {
			DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss");
			return time.format(form);
		}
		DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnn");
		return time.format(form);
    }
}