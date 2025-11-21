import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MonthlyPeriod {
    public String calculatePeriod(String startDate, String endDate) {
		try {
			LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String result = "";
            if (start.isAfter(end)) { LocalDate temp = start; start = end; end = temp; }
            Period p = Period.between(start, end);
            if (p.getYears() > 0) {
				result += p.getYears();
				if (p.getYears() == 1) {
					result += " year";
				} else {
					result += " years";
				}
			}
			if (p.getMonths() > 0) {
				if (!result.isEmpty()) { result += " and "; }
				result += p.getMonths();
				if (p.getMonths() == 1) {
					result += " month";
				} else {
					result += " months";
				}
			}
            return result;

        } catch (DateTimeParseException e) {
            return "Error";
        }
    }
}
