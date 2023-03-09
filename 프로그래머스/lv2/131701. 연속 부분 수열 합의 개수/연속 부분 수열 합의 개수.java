import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {

        int[] elementDouble = new int[elements.length * 2];
        for (int i = 0; i < elementDouble.length; i++) {
            elementDouble[i] = elements[i % elements.length];
        }

        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum = 0;
            for (int j = 0; j < elements.length; j++) {
                sum += elementDouble[i + j];
                sums.add(sum);
            }
        }

        return sums.size();
    }
}