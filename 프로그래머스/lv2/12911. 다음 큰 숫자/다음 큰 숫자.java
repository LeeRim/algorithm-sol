class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryN = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                count++;
            }
        }
        
        int countNext = 0;
        int next = n;
        String binaryNext = "";
        while (count != countNext) {
            countNext = 0;
            next++;
            binaryNext = Integer.toBinaryString(next);
            for (int i = 0; i < binaryNext.length(); i++) {
                if (binaryNext.charAt(i) == '1') {
                    countNext++;
                }
            }
        }
        
        answer = next;
        return answer;
    }
}