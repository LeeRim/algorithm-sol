import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> type = new HashMap<>();

        String clothesKey = "";
        int count = 0;
        for (int i = 0; i < clothes.length; i++) {
            clothesKey = clothes[i][1];
            if (type.containsKey(clothesKey)) {
                count = type.get(clothesKey);
                type.put(clothesKey, count + 1);
            } else {
                type.put(clothesKey, 1);
            }
        }

        count = 1;
        for (Integer value : type.values()) {
            count *= (value + 1);
        }

        int answer = count - 1;

        return answer;
    }
}