public class NextPrime {
    public static Integer nextPrime(Integer n) {
		if (n < 2) {
			return 2;
		}
        int num = n + 1;
		while (true) {
			if (isPrime(num)) {
				return num;
			}
			num++;
		}
    }
	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
