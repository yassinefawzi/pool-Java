import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectTime {
	private String startTime;
	private String endTime;
	private float hoursLogged;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public ProjectTime(String start, String end) {
		this.startTime = start;
		this.endTime = end;
		calculateHoursLogged();
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
		calculateHoursLogged();
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
		calculateHoursLogged();
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getHoursLogged() {
        if (hoursLogged == -1) {
            return "-1";
        }
        
        float totalMinutes = hoursLogged * 60;
                if (totalMinutes < 120 - 0.0001) {
            return Math.round(totalMinutes) + " m";
        } 
        else if (hoursLogged < 120 - 0.0001) {
            return (int) hoursLogged + " h";
        else if (hoursLogged < 2880 - 0.0001) {
            return (int) (hoursLogged / 24) + " d";
        } 
        else {
            return (int) (hoursLogged / 720) + " mo";
        }
    }

	private void calculateHoursLogged() {
		try {
			Date startDate = DATE_FORMAT.parse(startTime);
			Date endDate = DATE_FORMAT.parse(endTime);

			long startMillis = startDate.getTime();
			long endMillis = endDate.getTime();

			if (endMillis < startMillis) {
				hoursLogged = -1;
				return;
			}

			long durationMillis = endMillis - startMillis;
			double hours = (double) durationMillis / (1000 * 60 * 60);
			hoursLogged = (float) hours;

		} catch (ParseException e) {
			hoursLogged = -1;
		}
	}
}