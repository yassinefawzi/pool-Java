public class AnagramChecker {
    public boolean isAnagram(String str1, String str2) {
        String s1 = str1.toLowerCase();
        StringBuilder s2 = new StringBuilder(str2.toLowerCase());
        if (s1.length() != s2.length()) return false;
        for (char c : s1.toCharArray()) {
            int index = s2.indexOf(String.valueOf(c));
            if (index == -1) return false;
			s2.deleteCharAt(index);
        }

        return true;
    }
}
