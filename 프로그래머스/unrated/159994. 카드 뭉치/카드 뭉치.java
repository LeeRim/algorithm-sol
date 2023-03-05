class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        boolean canMake = true;
        int index1 = 0;
        int index2 = 0;
        for (String s : goal) {
            if (cards1.length > index1) {
                if (cards1[index1].equals(s)) {
                    index1++;
                    continue;
                }
            }
            if (cards2.length > index2) {
                if (cards2[index2].equals(s)) {
                    index2++;
                    continue;
                }
            }
            canMake = false;
        }

        return canMake ? "Yes" : "No";
    }
}