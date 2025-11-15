import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(
        Map<String, List<String>> menPreference,
        Map<String, List<String>> womenPreference) {
        Map<String, String> res = new HashMap<>();
        Set<String> unmatchedMen = new HashSet<>(menPreference.keySet());
        Map<String, String> womanToPartner = new HashMap<>();
        while (!unmatchedMen.isEmpty()) {
            String man = unmatchedMen.iterator().next();
            List<String> preferredWomenList = menPreference.get(man);
            for (String woman : preferredWomenList) {
                if (!womanToPartner.containsKey(woman)) {
                    womanToPartner.put(woman, man);
                    res.put(man, woman);
                    unmatchedMen.remove(man);
                    break;
                }
                String currentMan = womanToPartner.get(woman);
                List<String> womanPriorityList = womenPreference.get(woman);
                if (womanPriorityList.indexOf(man) < womanPriorityList.indexOf(currentMan)) {
                    womanToPartner.put(woman, man);
                    res.put(man, woman);
                    unmatchedMen.remove(man);
                    unmatchedMen.add(currentMan);
                    break;
                }
            }
        }
        return res;
    }
}
