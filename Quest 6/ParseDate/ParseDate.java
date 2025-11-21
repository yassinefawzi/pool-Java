import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ParseDate {
	public static LocalDateTime parseIsoFormat(String stringDate) {
		if (stringDate == null || stringDate.isEmpty()) {
			return null;
		}
		return LocalDateTime.parse(stringDate);
	}

	public static LocalDate parseFullTextFormat(String stringDate) {
		if (stringDate == null || stringDate.isEmpty()) {
			return null;
		}
        String[] holder = stringDate.split(" ");
        int day = Integer.parseInt(holder[1]);
        String monthText = holder[2].toLowerCase();
        List<String> months = List.of(
        "january", "february", "march", "april", "may", "june",
        "july", "august", "september", "october", "november", "december"
    	);
		int index = months.indexOf(monthText);
		if (index == -1) {
			throw new IllegalArgumentException("Invalid month name: " + monthText);
		}
		int month = index + 1;
		int year = Integer.parseInt(holder[3]);
		return LocalDate.of(year, month, day);
    }

	public static LocalTime parseTimeFormat(String stringDate) {
		if (stringDate == null || stringDate.isEmpty()) {
			return null;
		}
		boolean isEvening = stringDate.toLowerCase().contains("evening");
		String[] holder = stringDate.split(" ");
		int hour = Integer.parseInt(holder[0]);
		int minute = Integer.parseInt(holder[5]);
		int second = Integer.parseInt(holder[8]);
		if (isEvening) {
			hour += 12;
		}
		return LocalTime.of(hour, minute, second);
	}
}
