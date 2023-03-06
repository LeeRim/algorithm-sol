class Solution {
    public int solution(String s) {

        int count = 0;
        String before = "";
        while (!before.equals(s)) {
            before = s;
            s = slice(s);
            count++;
        }

        return count;
    }

    public String slice(String s){
        char x = s.charAt(0);

        int index = 0;
        int countX = 1;
        for (int i = 1; i < s.length(); i++) {
            if (countX == 0) {
                index = i;
                break;
            }

            if (s.charAt(i) == x) {
                countX++;
                continue;
            }
            countX--;
        }

        return s.substring(index);
    }
}