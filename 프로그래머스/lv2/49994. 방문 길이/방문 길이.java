import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Map<Character, Integer> dirIndex = new HashMap<>();
        dirIndex.put('U', 0);
        dirIndex.put('D', 1);
        dirIndex.put('L', 2);
        dirIndex.put('R', 3);

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Set<String> visited = new HashSet<>();
        int count = 0;
        int x = 0;
        int y = 0;
        int index, nx, ny;
        StringBuilder visit;
        for (int i = 0; i < dirs.length(); i++) {
            index = dirIndex.get(dirs.charAt(i));
            nx = x + dx[index];
            ny = y + dy[index];

            if (nx < -5 || ny < -5 || nx > 5 || ny > 5) {
                continue;
            }

            visit = new StringBuilder();
            visit.append(x)
                    .append(y)
                    .append(nx)
                    .append(ny);
            if (visited.contains(visit.toString())) {
                x = nx;
                y = ny;
                continue;
            }
            visited.add(visit.toString());
            visit = new StringBuilder();
            visit.append(nx)
                    .append(ny)
                    .append(x)
                    .append(y);
            visited.add(visit.toString());
            count++;

            x = nx;
            y = ny;
        }

        return count;
    }
}