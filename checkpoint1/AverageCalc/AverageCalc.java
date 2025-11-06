public class AverageCalc {
    public static int average(int start, int end, int step) {
        int sum = 0;
        int count = 0;

        if (step == 0) return 0;
        if (start <= end) {
            for (int i = start; i <= end; i += step) {
                sum += i;
                count++;
            }
        } else {
            for (int i = start; i >= end; i += step) {
                sum += i;
                count++;
            }
        }

        if (count == 0) return 0;
        return sum / count;
    }
}
