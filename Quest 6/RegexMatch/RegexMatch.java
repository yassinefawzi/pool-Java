public class RegexMatch {
    public static boolean containsOnlyAlpha(String s) {
        return s != null && s.matches("[A-Za-z]+");
    }
    
    public static boolean startWithLetterAndEndWithNumber(String s) {
        return s != null && s.matches("^[A-Za-z].*[0-9]$");
    }
    
    public static boolean containsAtLeast3SuccessiveA(String s) {
		return s != null && s.matches(".*AAA.*");
    }
}
