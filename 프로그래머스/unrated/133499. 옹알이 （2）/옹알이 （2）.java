class Solution {
    public int solution(String[] babbling) {
        String[] ables = {"aya", "ye", "woo", "ma"};

        int answer = 0;
        for (String bab : babbling) {
            String pre = "";
            for (int i = 0; i < ables.length; i++) {
                String able = ables[i];
                if (bab.startsWith(able) && !pre.equals(able)) {
                    bab = bab.substring(able.length());
                    if (bab.length() == 0) {
                        answer++;
                        break;
                    }
                    pre = able;
                    i = -1;
                }
            }
        }

//        System.out.println(answer);
        return answer;
    }
}