import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigProtector {
	public String hideSensitiveData(String configFile, List<String> sensitiveKeys) {
		if (configFile == null || sensitiveKeys == null || sensitiveKeys.isEmpty()) {
			return configFile;
		}
		for (String key : sensitiveKeys) {
			String reg = "(?m)^" + key + "=.*$";
			Pattern pat = Pattern.compile(reg);
			Matcher mat = pat.matcher(configFile);
			StringBuffer sb = new StringBuffer();
			while (mat.find()) {
				String value = mat.group();
				int i = value.indexOf("=");
				String hidden = value.substring(0, i + 1) + "*".repeat(value.length() - i - 1);
				mat.appendReplacement(sb, hidden);
			}
			mat.appendTail(sb);
			configFile = sb.toString();
		}
		return configFile;
	}
}
