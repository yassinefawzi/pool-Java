import java.util.List;
import java.util.ArrayList;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
         if (list == null) {
            return null;
        }
        int index = list.lastIndexOf(value);
		if (index == -1) return null;
        return index;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
         if (list == null) {
            return null;
        }
        int index = list.indexOf(value);
		if (index == -1) return null;
        return index;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> res = new ArrayList<>();
         if (list == null) {
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                res.add(i);
            }
        }

        return res;
    }
}
