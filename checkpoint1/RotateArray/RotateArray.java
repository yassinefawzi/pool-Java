public class RotateArray {
    public static Integer[] rotate(Integer[] arr, int rotationCount) {
        int n = arr.length;
        if (n == 0) return arr;

        rotationCount = rotationCount % n;
        if (rotationCount < 0) rotationCount += n;

        Integer[] result = new Integer[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + rotationCount) % n;
            result[newIndex] = arr[i];
        }
        return result;
    }
}
