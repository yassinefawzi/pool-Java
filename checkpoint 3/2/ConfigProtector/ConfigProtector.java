import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigProtector {

    public String hideSensitiveData(String configFile, List<String> sensitiveKeys) {
        if (configFile == null || sensitiveKeys == null || sensitiveKeys.isEmpty()) {
            return configFile;
        }

        String protectedConfig = configFile;

        for (String key : sensitiveKeys) {
            // Regex: key= followed by any characters except newline
            String regex = "(?m)^" + Pattern.quote(key) + "=.*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(protectedConfig);

            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String value = matcher.group();
                int equalIdx = value.indexOf("=");
                String masked = value.substring(0, equalIdx + 1) + "*".repeat(value.length() - equalIdx - 1);
                matcher.appendReplacement(sb, masked);
            }
            matcher.appendTail(sb);
            protectedConfig = sb.toString();
        }

        return protectedConfig;
    }
}
