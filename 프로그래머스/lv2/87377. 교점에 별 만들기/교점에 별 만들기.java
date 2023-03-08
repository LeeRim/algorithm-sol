import java.util.ArrayList;
import java.util.List;

class Solution {
    long minX, minY;
    long maxX, maxY;
    List<long[]> points;
    public String[] solution(int[][] line) {
        minX = Long.MAX_VALUE;
        minY = Long.MAX_VALUE;
        maxX = Long.MIN_VALUE;
        maxY = Long.MIN_VALUE;

        points = new ArrayList<>();

        makeCombi(line, 0, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxX - minX; i++) {
            sb.append('.');
        }
        String[] answer = new String[(int) (maxY - minY + 1)];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sb.toString();
        }
        int x, y;
        for (long[] point : points) {
            x = (int) (point[0] - minX);
            y = (int) ((point[1] - maxY) * -1);
            answer[y] = answer[y].substring(0, x) + "*" + answer[y].substring(x + 1);
        }

        return answer;
    }

    public void makeCombi(int[][] line, int lineIndex, List<int[]> pick) {
        if (pick.size() == 2) {
            long[] point = getPoint(pick);
            if (point == null) {
                return;
            }
            points.add(point);
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            minY = Math.min(minY, point[1]);
            maxY = Math.max(maxY, point[1]);
            return;
        }
        if (2 - pick.size() > line.length - lineIndex) {
            return;
        }

        makeCombi(line, lineIndex + 1, new ArrayList<>(pick));
        pick.add(line[lineIndex]);
        makeCombi(line, lineIndex + 1, new ArrayList<>(pick));
    }

    public long[] getPoint(List<int[]> lines) {
        double adbc = lines.get(0)[0] * (double)lines.get(1)[1] - lines.get(0)[1] * (double)lines.get(1)[0];
        if (adbc == 0) {
            return null;
        }

        double bfed = lines.get(0)[1] * (double)lines.get(1)[2] - lines.get(0)[2] * (double)lines.get(1)[1];
        double ecaf = lines.get(0)[2] * (double)lines.get(1)[0] - lines.get(0)[0] * (double)lines.get(1)[2];
        if (bfed % adbc == 0 && ecaf % adbc == 0) {
            long[] point = new long[2];
            point[0] = (long) (bfed / adbc);
            point[1] = (long) (ecaf / adbc);

            return point;
        }

        return null;
    }
}