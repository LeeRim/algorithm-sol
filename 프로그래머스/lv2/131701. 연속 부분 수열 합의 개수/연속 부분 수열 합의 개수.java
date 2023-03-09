import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum = 0;
            for (int j = 0; j < elements.length; j++) {
                if (i + j >= elements.length) {
                    sum += elements[(i + j) % elements.length];
                } else {
                    sum += elements[i + j];
                } 
                sums.add(sum);
            }
        }

        return sums.size();
    }
}