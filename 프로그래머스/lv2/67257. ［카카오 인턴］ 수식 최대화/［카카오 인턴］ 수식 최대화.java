import java.util.*;

class Solution {

    List<String> exp;
    long max;
    public long solution(String expression) {
        max = Long.MIN_VALUE;

        Set<Character> operation = new HashSet<>();
        exp = new LinkedList<>();
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) < '0') {
                exp.add(num);
                num = "";
                exp.add(String.valueOf(expression.charAt(i)));
                operation.add(expression.charAt(i));
                continue;
            }
            num += expression.charAt(i);
        }
        exp.add(num);

        makePriority(new ArrayList<>(operation), new boolean[operation.size()], new ArrayList<>());

        return max;
    }

    public void makePriority(List<Character> operator, boolean[] visited, List<Character> operatorPriority) {
        if (operatorPriority.size() == operator.size()) {
            max = Math.max(max, calculate(operatorPriority));
            return;
        }

        for (int i = 0; i < operator.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            operatorPriority.add(operator.get(i));
            makePriority(operator, visited.clone(), new ArrayList<>(operatorPriority));
            operatorPriority.remove(operatorPriority.size() - 1);
            visited[i] = false;
        }
    }

    public long calculate(List<Character> operatorPriority) {
        List<String> expression = new LinkedList<>(exp);

        long num = 0;
        int index;
        for (Character character : operatorPriority) {
            while (expression.indexOf(String.valueOf(character)) >= 0) {
                index = expression.indexOf(String.valueOf(character));

                switch (expression.get(index)) {
                    case "+":
                        num = Long.parseLong(expression.get(index - 1)) + Long.parseLong(expression.get(index + 1));
                        break;
                    case "-":
                        num = Long.parseLong(expression.get(index - 1)) - Long.parseLong(expression.get(index + 1));
                        break;
                    case "*":
                        num = Long.parseLong(expression.get(index - 1)) * Long.parseLong(expression.get(index + 1));
                        break;
                }

                expression.set(index, String.valueOf(num));
                expression.remove(index + 1);
                expression.remove(index - 1);
            }
        }

        long result = Long.parseLong(expression.get(0));
        return Math.abs(result);
    }
}