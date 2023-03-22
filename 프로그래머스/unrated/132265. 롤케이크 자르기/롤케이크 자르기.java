import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {

        Map<Integer, Integer> bro1 = new HashMap<>();
        Map<Integer, Integer> bro2 = new HashMap<>();
        for (int t : topping) {
            if (!bro2.containsKey(t)) {
                bro2.put(t, 0);
            }
            bro2.replace(t, bro2.get(t) + 1);
        }

        int count = 0;
        for (int t : topping) {
            if (bro1.size() > bro2.size()) {
                break;
            }
            if (bro1.size() == bro2.size()) {
                count++;
            }
            if (!bro1.containsKey(t)) {
                bro1.put(t, 0);
            }
            bro1.replace(t, bro1.get(t) + 1);
            if (bro2.get(t) == 1) {
                bro2.remove(t);
                continue;
            }
            bro2.replace(t, bro2.get(t) - 1);
        }
        
        return count;
    }
}