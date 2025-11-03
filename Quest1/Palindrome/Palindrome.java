public class Palindrome {
    public static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
        StringBuilder holder = new StringBuilder(s.toLowerCase());
        holder.reverse();
        return s.equalsIgnoreCase(holder.toString());
    }
}
