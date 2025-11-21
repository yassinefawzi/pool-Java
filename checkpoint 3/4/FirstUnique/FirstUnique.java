import java.util.*;

public class FirstUnique {
    public char findFirstUnique(String s) {
        if (s == null || s.isEmpty()) return '_';
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : countMap.keySet()) {
            if (countMap.get(c) == 1) {
                return c;
            }
        }
        return '_';
    }
}
