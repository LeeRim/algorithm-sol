import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long left, long right) {

        int leftx = (int) (left / n);
        int lefty = (int) (left % n);
        int rightx = (int) (right / n);
        int righty = (int) (right % n);
        
        List<Integer> list = new ArrayList<>();
        for (int i = leftx; i <= rightx; i++) {
            for (int j = 0; j < n; j++) {
                if (i == rightx && j > righty) {
                    break;
                }
                if (i == leftx && j < lefty) {
                    continue;
                }
                list.add(Math.max(i + 1, j + 1));
            }
        }
        
//        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}