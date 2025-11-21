import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeFinder {
    public int calculateAge(String date) {
        try {
            LocalDate birthDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate today = LocalDate.now();
            if (birthDate.isAfter(today)) return -1;
            Period p = Period.between(birthDate, today);
            return p.getYears();
        } catch (DateTimeParseException e) {
            return -1;
        }
    }
}
