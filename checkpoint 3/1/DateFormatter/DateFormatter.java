import java.util.Calendar;
import java.util.TimeZone;
import java.util.Date;

public class DateFormatter {
	private long date;
	private String format;
	private String formattedDate;
	private static final String[] MONTHS = {
			"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"
	};

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

	public String getFormat() {
		return format;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setDate(long date) {
		this.date = date;
		convert();
	}

	public void setFormat(String format) {
		this.format = format;
		convert();
	}

	private void convert() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTime(new Date(date * 1000L));

		int day = cal.get(Calendar.DAY_OF_MONTH);
		int monthIdx = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		String d = (day < 10 ? "0" + day : "" + day);
		String mNum = (monthIdx + 1 < 10 ? "0" + (monthIdx + 1) : "" + (monthIdx + 1));
		String mName = MONTHS[monthIdx];
		String lower = format.toLowerCase();

		switch (lower) {
			case "dd/mm/yyyy":
				formattedDate = d + "/" + mNum + "/" + year;
				break;
			case "dd.mm.yyyy":
				formattedDate = d + "." + mNum + "." + year;
				break;
			case "dd month yyyy":
				formattedDate = d + " " + mName + " " + year;
				break;
		}
	}

}
