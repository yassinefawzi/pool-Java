public class AlmostPalindrome {
    public static boolean isAlmostPalindrome(String s) {
        s = s.toLowerCase();

        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;

            if (s.charAt(i) != s.charAt(j)) {
                String a = s.substring(0, i) + s.substring(i + 1);
                String b = s.substring(0, j) + s.substring(j + 1);
                return isPal(a) || isPal(b);
            }
        }
        return false;
    }
    private static boolean isPal(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
