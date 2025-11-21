import java.util.*;

public class BreakdownURL {
    public Map<String, String> parseURL(String url) {
        Map<String, String> comp = new LinkedHashMap<>();
        if (url == null || url.isEmpty()) return comp;
        int p = url.indexOf("://");
        if (p != -1) {
            comp.put("protocol", url.substring(0, p));
            url = url.substring(p + 3);
        }
        int s = url.indexOf("/");
        String domainPort = s == -1 ? url : url.substring(0, s);
        url = s == -1 ? "" : url.substring(s);

        int c = domainPort.indexOf(":");
        if (c != -1) {		
            comp.put("domain", domainPort.substring(0, c));
            comp.put("port", domainPort.substring(c + 1));
        } else {
            comp.put("domain", domainPort);
        }
        if (!url.isEmpty()) {
            int q = url.indexOf("?");
            if (q != -1) {
                comp.put("path", url.substring(0, q));
                comp.put("query", url.substring(q + 1));
            } else {
                comp.put("path", url);
            }
        } else {
            comp.put("path", "/");
        }

        return comp;
    }
}
