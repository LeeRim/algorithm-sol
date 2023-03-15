class Solution {
    int answer;
    int count;
    boolean isDone;
    char[] chars = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        count = 0;
        isDone = false;

        makeWord(word, new StringBuilder());

        return answer;
    }

    public void makeWord(String word, StringBuilder str) {
        if (isDone) {
            return;
        }
        if (word.equals(str.toString())) {
            isDone = true;
            answer = count;
            return;
        }
        if (str.length() >= 5) {
            return;
        }


        for (int i = 0; i < 5; i++) {
            count++;
            str.append(chars[i]);
            makeWord(word, new StringBuilder(str));
            str.deleteCharAt(str.length() - 1);
        }
    }
}