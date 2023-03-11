import java.util.ArrayList;
import java.util.List;

class Solution {
    int max;
    public int solution(int k, int[][] dungeons) {
        max = 0;
        getPermutation(dungeons, k, new boolean[dungeons.length], new ArrayList<>());

        return max;
    }

    public void getPermutation(int[][] dungeons, int k, boolean[] visited, List<int[]> permutations) {
        if (max == dungeons.length) {
            return;
        }
        if (!permutations.isEmpty() && k < permutations.get(permutations.size() - 1)[0]) {
            max = Math.max(max, permutations.size() - 1);
            return;
        }
        if (permutations.size() == dungeons.length) {
            max = dungeons.length;
            return;
        }

        if (!permutations.isEmpty()) {
            k -= permutations.get(permutations.size() - 1)[1];
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permutations.add(dungeons[i]);
            getPermutation(dungeons, k, visited.clone(), new ArrayList<>(permutations));
            visited[i] = false;
            permutations.remove(permutations.size() - 1);
        }
    }
}