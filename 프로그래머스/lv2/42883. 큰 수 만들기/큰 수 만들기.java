class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = 0;
        int i = 0;
        String str = "";
        String max = "";
        while (n < number.length() - k) {
            n++;
//            System.out.println("i : " + i + ", n : " + (k+n));
            str = number.substring(i, k + n);
//            System.out.println(str);
            max = String.valueOf(Character.getNumericValue(str.chars().max().getAsInt()));
//            System.out.println(max);
            answer += max;
            i += str.indexOf(max) + 1;
        }
//            System.out.println(answer);
        return answer;
    }
}