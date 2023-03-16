import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucks = new LinkedList<Integer>();
        for (int t : truck_weights) {
            trucks.add(t);
        }
        ArrayDeque<Integer> bridge_trucks = new ArrayDeque<Integer>();
        bridge_trucks.add(0);
        int in_bridge = 0;
        int truck = 0;
        while (bridge_trucks.peek() != -1) {
            if (bridge_trucks.size() == bridge_length) {
                truck = bridge_trucks.poll();
                in_bridge -= truck;
            }
            if (!trucks.isEmpty()) {
                if ((in_bridge + trucks.peek()) <= weight) {
                    truck = trucks.poll();
                    in_bridge += truck;
                    bridge_trucks.add(truck);
                } else {
                    bridge_trucks.add(0);
                }
            } else {
                bridge_trucks.add(-1);
            }

//            System.out.println(bridge_trucks);
            answer++;
        }
        // System.out.println(answer);
        return answer;
    }
}