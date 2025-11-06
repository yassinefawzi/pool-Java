public class Digitlen {
    public static int digitlen(long number) {
        if (number == 0) {
			return 1;
		}
		int count = 0;
		long num = Math.abs(number);
		while (num > 0) {
			num /= 10;
			count++;
		}
		return count;
    }
}
