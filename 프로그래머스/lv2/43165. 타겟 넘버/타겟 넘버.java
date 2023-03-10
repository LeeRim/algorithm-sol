import java.util.*;

class Solution {
    private int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, new ArrayList<>());

        return answer;
    }

    public void dfs(int[] numbers, int target, List<String> operater) {
        if (numbers.length == operater.size()) {
            checkSum(numbers, target, operater);
            return;
        }

        operater.add("+");
        dfs(numbers, target, new ArrayList<>(operater));
        operater.set(operater.size() - 1, "-");
        dfs(numbers, target, new ArrayList<>(operater));
    }

    public void checkSum(int[] numbers, int target, List<String> operater) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (operater.get(i).equals("+")) {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }

        if (sum == target) {
            answer++;
        }
    }
}