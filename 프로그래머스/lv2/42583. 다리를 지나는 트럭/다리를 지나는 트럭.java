import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int bridge_weight = weight;
        int truck = 0;
        int count = 0;
        int done;
        while (truck < truck_weights.length) {
            count++;
            done = bridge.poll();
            if (done > 0) {
                bridge_weight += done;
            }
            if (bridge_weight >= truck_weights[truck]) {
                bridge.add(truck_weights[truck]);
                bridge_weight -= truck_weights[truck];
                truck++;
            } else {
                bridge.add(0);
            }
        }

        return count + bridge_length;
    }
}