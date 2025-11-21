import java.util.Set;
import java.util.Stack;

public class HTMLValidator {
	private static final Set<String> TAGS = Set.of("html", "body", "div", "p", "b", "i", "h1", "h2");

	public boolean validateHTML(String html) {
		if (html == null || html.isEmpty())
			return false;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < html.length(); i++) {
			if (html.charAt(i) == '<') {
				int j = html.indexOf('>', i);
				if (j == -1) return false;

				String sub = html.substring(i + 1, j);
				boolean close = false;
				if (sub.startsWith("/")) {
					close = true;
					sub = sub.substring(1);
				}

				if (!TAGS.contains(sub)) {
					return false;
				}
				if (close) {
					if (stack.isEmpty())return false;
					String Eq = stack.pop();
					if (!Eq.equals(sub)) return false;
				} else {
					stack.push(sub);
				}
				i = j;
			}
		}
		return stack.isEmpty();
	}
}
