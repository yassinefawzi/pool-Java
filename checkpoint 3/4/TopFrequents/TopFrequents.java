import java.util.*;

public class TopFrequents {
    public List<Integer> findTopKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            firstIndex.putIfAbsent(nums[i], i);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freq.get(b).equals(freq.get(a)) 
                        ? Integer.compare(firstIndex.get(a), firstIndex.get(b))
                        : Integer.compare(freq.get(b), freq.get(a))
        );
        heap.addAll(freq.keySet());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !heap.isEmpty(); i++) result.add(heap.poll());
        return result;
    }
}
