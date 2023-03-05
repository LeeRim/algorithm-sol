class Solution {
    public int solution(String[] babbling) {

        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (isCan(babbling[i])) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isCan(String word) {
        String[] strs = {"aya", "ye", "woo", "ma"};

        boolean isCan;
        String before = "";
        while (word.length() > 0) {
            isCan = false;
            for (int i = 0; i < strs.length; i++) {
                if (word.startsWith(strs[i]) && !strs[i].equals(before)) {
                    before = strs[i];
                    word = word.substring(strs[i].length());
                    isCan = true;
                }
            }
            if (!isCan) {
                return false;
            }
        }

        return true;
    }
}