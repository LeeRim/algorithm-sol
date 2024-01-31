import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] ints = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        sb.append(" ");
        sb.append(ints[ints.length - 1]);

        return sb.toString();
    }
}