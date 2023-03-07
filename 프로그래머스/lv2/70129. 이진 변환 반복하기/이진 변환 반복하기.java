class Solution {
    public int[] solution(String s) {

        int changeCount = 0;
        int count0 = 0;
        int count;
        while (!s.equals("1")) {
            count = getCount0(s);
            count0 += count;
            s = Integer.toBinaryString(s.length() - count);
            changeCount++;
        }

        int[] answer = {changeCount, count0};
        return answer;
    }
    
    public int getCount0(String s) {
        return (int) s.chars()
                .filter(c -> c == '0')
                .count();
    }
}