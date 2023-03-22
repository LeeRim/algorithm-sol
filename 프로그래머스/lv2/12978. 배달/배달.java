
import java.util.*;

class Solution {
    public int solution(int n, int[][] road, int k) {
        Map<Integer, List<NodeCost>> graph = new HashMap<>();
        for (int[] ints : road) {
            if (!graph.containsKey(ints[0])) {
                graph.put(ints[0], new ArrayList<>());
            }
            graph.get(ints[0]).add(new NodeCost(ints[1], ints[2]));

            if (!graph.containsKey(ints[1])) {
                graph.put(ints[1], new ArrayList<>());
            }
            graph.get(ints[1]).add(new NodeCost(ints[0], ints[2]));
        }


        int[] distance = new int[n + 1];
        distance[1] = 0;
        for (int i = 2; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<NodeCost> costHeap = new PriorityQueue<>();
        costHeap.add(new NodeCost(1, 0));
        while (!costHeap.isEmpty()) {
            NodeCost now = costHeap.poll();
            if (distance[now.node] < now.cost) {
                continue;
            }

            List<NodeCost> nextTos = graph.get(now.node);
            for (NodeCost nextTo : nextTos) {
                if (distance[nextTo.node] > now.cost + nextTo.cost) {
                    distance[nextTo.node] = now.cost + nextTo.cost;
                    costHeap.add(new NodeCost(nextTo.node, distance[nextTo.node]));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] <= k) {
                count++;
            }
        }

        return count;
    }


    class NodeCost implements Comparable<NodeCost> {
        int node;
        int cost;

        public NodeCost(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(NodeCost o) {
            return cost - o.cost;
        }
    }
}