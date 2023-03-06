import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] ints = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.stream(ints).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(ints).max().getAsInt());

        return sb.toString();
    }
}