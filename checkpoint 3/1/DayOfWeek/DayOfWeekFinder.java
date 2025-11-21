import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayOfWeekFinder {
    public String findNextDayOfWeek(String startDate, String dayOfWeekStr) {
        try {
            LocalDate date = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            DayOfWeek targetDay;
            switch(dayOfWeekStr.toLowerCase()) {
                case "monday": targetDay = DayOfWeek.MONDAY; break;
                case "tuesday": targetDay = DayOfWeek.TUESDAY; break;
                case "wednesday": targetDay = DayOfWeek.WEDNESDAY; break;
                case "thursday": targetDay = DayOfWeek.THURSDAY; break;
                case "friday": targetDay = DayOfWeek.FRIDAY; break;
                case "saturday": targetDay = DayOfWeek.SATURDAY; break;
                case "sunday": targetDay = DayOfWeek.SUNDAY; break;
                default: return "Error";
            }
			int daysToAdd = (targetDay.getValue() - date.getDayOfWeek().getValue() + 7) % 7;
            if(daysToAdd == 0) daysToAdd = 7;
            return date.plusDays(daysToAdd).toString();
        } catch (DateTimeParseException e) {
            return "Error";
        }
    }
}
