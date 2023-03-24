import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> areas = getArea(k);

        int len = areas.size();

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            answer[i] = getRangeArea(areas, ranges[i][0], len + ranges[i][1]);
        }

        return answer;
    }

    public List<Double> getArea(int k) {
        List<Double> areas = new ArrayList<>();

        List<Integer> nums = new ArrayList<>();
        nums.add(k);

        int temp;
        while (k != 1) {
            if (k % 2 == 0) {
                temp = k / 2;
                areas.add(temp * 1.5);
            } else {
                temp = k * 3;
                temp++;
                areas.add(k * 2 + 0.5);
            }

            k = temp;
            nums.add(k);
        }

        return areas;
    }

    public double getRangeArea(List<Double> areas, int a, int b) {
        if (a == b) {
            return 0;
        }
        if (a > b) {
            return -1;
        }
        double area = 0;
        for (int i = a; i < b; i++) {
            area += areas.get(i);
        }
        return area;
    }
}