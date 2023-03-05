class Solution {
    public int solution(int number, int limit, int power) {

        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (getCounts(i) > limit) {
                sum += power;
                continue;
            }
            sum += getCounts(i);
        }

        return sum;
    }

    public int getCounts(int num) {
        if (num < 2) {
            return 1;
        }
        int count = 2;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                count += 2;
            }
        }
        if (num % Math.sqrt(num) == 0) {
            count++;
        }
        return count;
    }
}