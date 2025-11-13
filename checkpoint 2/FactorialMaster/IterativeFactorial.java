public class IterativeFactorial extends Factorial {
    @Override
    public long calculate(int n) {
		long result;
        for (result = 1; n > 1; n--) {
			result *= n;
		}
		return result;
    }
}