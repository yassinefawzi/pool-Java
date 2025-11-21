import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeFinder {
    public int calculateAge(String date) {
        try {
			LocalDate now = LocalDate.now();
			LocalDate birth = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			if (birth.isAfter(now)) return -1;
			Period bet = Period.between(birth, now);
			return bet.getYears();
		} catch (Exception e) {
			return -1;
		}
    }
}
