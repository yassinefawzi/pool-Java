public class DistinctSubstringLength {
    public int maxLength(String s) {
        int[] lastIndex = new int[128];
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            start = Math.max(start, lastIndex[c]);
            maxLen = Math.max(maxLen, i - start + 1);
            lastIndex[c] = i + 1;
        }

        return maxLen;
    }
}
