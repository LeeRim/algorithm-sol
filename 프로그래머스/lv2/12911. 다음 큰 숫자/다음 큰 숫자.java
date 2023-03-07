class Solution {
    public int solution(int n) {
        int nCount = getCount1(n);
        
        int next = n + 1;
        while (nCount != getCount1(next)) {
            next++;
        }
        
        return next;
    }

    public int getCount1(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}