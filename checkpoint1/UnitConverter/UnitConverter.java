public class UnitConverter {
	public static String convert(String[] args) {
		if (args == null || args.length != 3) {
			return "ERROR";
		}
		String from = args[0].toLowerCase();
		String to = args[1].toLowerCase();
		double value;
		double result;
		try {
			value = Double.parseDouble(args[2]);
		} catch (NumberFormatException err) {
			return "ERROR";
		}

		if (from.equals("fahrenheit") && to.equals("celsius")) {
			result = (value - 32) * 5 / 9;
		} else if (from.equals("celsius") && to.equals("fahrenheit")) {
			result = value * 9 / 5 + 32;
		} else if (from.equals("kilometers") && to.equals("miles")) {
			result = value * 0.621371;
		} else if (from.equals("miles") && to.equals("kilometers")) {
			result = value * 1.60934;
		} else if (from.equals("pounds") && to.equals("kilograms")) {
			result = value * 0.45359237;
		} else {
			return "ERROR";
		}

		return String.format("%.2f", result);
	}
}