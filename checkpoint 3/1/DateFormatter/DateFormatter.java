import java.util.Date;
import java.util.TimeZone;
import java.util.Calendar;

public class DateFormatter {
	private long date;
	private String formattedDate;
	private String format;
	private String[] Months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };

	public DateFormatter() {
		this(System.currentTimeMillis() / 1000L, "DD/MM/YYYY");
	}

	public DateFormatter(long date) {
		this(date, "DD/MM/YYYY");
	}

	public DateFormatter(long date, String format) {
		this.date = date;
		this.format = format;
		convert();
	}

	public long getDate() {
		return date;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
		convert();
	}

	public void setDate(long date) {
		this.date = date;
		convert();
	}

	private void convert() {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date(date * 1000L));

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);

		String montname = Months[calendar.get(Calendar.MONTH)];
		String dayPrint = day < 10 ? "0" + day : "" + day;
		String monthN = month < 10 ? "0" + month : "" + month;
		switch (format.toLowerCase()) {
			case "dd/mm/yyyy":
				formattedDate = dayPrint + "/" + monthN + "/" + year;
				break;
			case "dd.mm.yyyy":
				formattedDate = dayPrint + "." + monthN + "." + year;
				break;
			case "dd month yyyy":
				formattedDate = dayPrint + " " + montname + " " + year;
				break;
		}

	}
}