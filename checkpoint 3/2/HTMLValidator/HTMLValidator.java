import java.util.*;

public class HTMLValidator {
    private static final Set<String> TAGS = Set.of("html","body","div","p","b","i","h1","h2");

    public boolean validateHTML(String html) {
        if (html == null || html.isEmpty()) return false;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<') {
                int j = html.indexOf('>', i);
                if (j == -1) return false;

                String tag = html.substring(i + 1, j);
                boolean closing = false;

                if (tag.startsWith("/")) {
                    closing = true;
                    tag = tag.substring(1);
                }

                if (!TAGS.contains(tag)) return false;

                if (closing) {
                    if (stack.isEmpty()) return false;
                    String openTag = stack.pop();
                    if (!openTag.equals(tag)) return false;
                } else {
                    stack.push(tag);
                }
                i = j; // move past '>'
            }
        }
        return stack.isEmpty();
    }
}
