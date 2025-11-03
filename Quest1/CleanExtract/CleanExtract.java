public class CleanExtract {
	public static String extract(String s) {
		String[] parts = s.split("\\|");
		StringBuilder result = new StringBuilder();
		for (String part : parts) {
			part = part.trim();
			int firstDot = part.indexOf('.');
			int lastDot = part.lastIndexOf('.');
			if (firstDot != -1 && lastDot != -1) {
				String extracted;
				if (firstDot == lastDot) {
					extracted = part.substring(firstDot + 1).trim();
				} else {
					extracted = part.substring(firstDot + 1, lastDot).trim();
				}
				if (extracted != "") {
					if (result.length() > 0)
						result.append(" ");
					result.append(extracted);
				}
			}
		}
		return result.toString();
	}
}