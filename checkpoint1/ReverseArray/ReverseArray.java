public class ReverseArray {
    public static Integer[] reverse(Integer[] arr) {
        Integer[] reversed = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
}
