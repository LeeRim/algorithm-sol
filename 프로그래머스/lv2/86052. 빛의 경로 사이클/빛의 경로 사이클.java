import java.util.*;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] grid) {

        List<Integer> cycles = new ArrayList<>();
        Set<Point> pres = new HashSet<>();
        int count, nx, ny, index;
        boolean isCycle;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                for (int k = 0; k < dx.length; k++) {
                    isCycle = false;
                    count = 0;
                    Point start = new Point(i, j, k);
                    Point now = new Point(i, j, k);
                    while (!pres.contains(now)) {
                        pres.add(now);

                        nx = now.x + dx[now.index];
                        ny = now.y + dy[now.index];
                        if (nx < 0) {
                            nx = grid.length - 1;
                        }
                        if (nx >= grid.length) {
                            nx = 0;
                        }
                        if (ny < 0) {
                            ny = grid[0].length() - 1;
                        }
                        if (ny >= grid[0].length()) {
                            ny = 0;
                        }

                        index = now.index;
                        char nowChar = grid[nx].charAt(ny);
                        if (nowChar == 'R') {
                            index++;
                            if (index == 4) {
                                index = 0;
                            }
                        }
                        if (nowChar == 'L') {
                            index--;
                            if (index == -1) {
                                index = 3;
                            }
                        }

                        now = new Point(nx, ny, index);
                        count++;
                        if (start.equals(now)) {
                            isCycle = true;
                            break;
                        }
                    }
                    if (isCycle) {
                        cycles.add(count);
                    }
                }
            }
        }

        return cycles.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
    }

    class Point{
        int x;
        int y;
        int index;

        public Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && index == point.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, index);
        }
    }
}