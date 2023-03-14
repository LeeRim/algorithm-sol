import java.util.*;

class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    private char[] reverse = {'D', 'U', 'R', 'L'};

    public int solution(String dirs) {
        Map<Character, Integer> indexs = new HashMap<>();
        indexs.put('U', 0);
        indexs.put('D', 1);
        indexs.put('L', 2);
        indexs.put('R', 3);

        Set<Way> visited = new HashSet<>();
        //현재 좌표
        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int index = indexs.get(dirs.charAt(i));
            //다음 좌표
            int nx = x + dx[index];
            int ny = y + dy[index];
            //좌표 범위를 넘어가면 무시
            if (nx < -5 || ny < -5 || nx > 5 || ny > 5) {
                continue;
            }
            Way right = new Way(x, y, dirs.charAt(i));
            x = nx;
            y = ny;
            //방문했던 Way면 다음 좌표 실행
            if (visited.contains(right)) {
                continue;
            }
            //Way를 방문 set에 추가
            visited.add(right); //현재 좌표 + 방향
            visited.add(new Way(nx, ny, reverse[index])); //다음 좌표 + 역방향
        }

        int count = visited.size() / 2;
        return count;
    }

    class Way {

        int x;
        int y;
        char direction;

        public Way(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Way way = (Way) o;
            return x == way.x && y == way.y && direction == way.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction);
        }
    }
}