import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> res = new ArrayList<>();
        List<Integer> sortedCoin = new ArrayList<>(coins);
        Collections.sort(sortedCoin, Collections.reverseOrder());
        for (int coin : sortedCoin) {
            while (amount >= coin) {
                res.add(coin);
                amount -= coin;
            }
        }
        return res;
    }
}