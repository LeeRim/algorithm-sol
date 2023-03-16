import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        List<String> strs = new ArrayList<>();
        for (int number : numbers) {
            strs.add(String.valueOf(number));
        }

        strs.sort((o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });

        if(strs.get(0).startsWith("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}