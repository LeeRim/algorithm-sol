import java.util.ArrayList;
import java.util.List;

class Solution {
    int count;
    String[] condition;
    public int solution(int n, String[] data) {
        count = 0;
        condition = data;
        char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        getPermutation(members, new boolean[8], new ArrayList<>());

        return count;
    }

    public void getPermutation(char[] members, boolean[] visited, List<Character> permutation) {
        if (permutation.size() == 8) {
            if (check(permutation)) {
                count++;
            }
            return;
        }

        for (int i = 0; i < members.length; i++) {
            if (!visited[i]) {
                permutation.add(members[i]);
                visited[i] = true;
                getPermutation(members, visited.clone(), new ArrayList<>(permutation));
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public boolean check(List<Character> permutation) {
        int a, b;
        int between, num;
        boolean result = true;
        for (String s : condition) {
            a = permutation.indexOf(s.charAt(0));
            b = permutation.indexOf(s.charAt(2));
            between = Math.abs(a - b) - 1;
            num = Character.getNumericValue(s.charAt(4));

            switch (s.charAt(3)) {
                case '=':
                    result = between == num;
                    break;
                case '<':
                    result = between < num;
                    break;

                case '>':
                    result = between > num;
                    break;
            }

            if (!result) {
                return false;
            }
        }

        return true;
    }
}