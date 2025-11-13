import java.util.HashSet;
import java.util.Set;

public class SteadySequence {
    public int longestSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLength = 0;

        for (int num : set) {
            // Only start counting if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
