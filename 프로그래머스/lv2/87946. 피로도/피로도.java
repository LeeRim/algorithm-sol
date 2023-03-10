class Solution {
    private int max;
    public int solution(int k, int[][] dungeons) {
        max = 0;
        dfs(dungeons, new boolean[dungeons.length], k, 0);
        return max;
    }

    public void dfs(int[][] dungeons, boolean[] visited, int k, int count) {
        int visitCount = 0;
        for (boolean b : visited) {
            if (b) {
                visitCount++;
            }
        }
        if (visitCount == visited.length) {
            max = Math.max(max, count);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (k < dungeons[i][0]) {
                dfs(dungeons, visited.clone(), k, count);
                continue;
            }
            dfs(dungeons, visited.clone(), k - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}