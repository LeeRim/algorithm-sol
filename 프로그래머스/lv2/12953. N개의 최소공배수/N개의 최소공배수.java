import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        LinkedList<Integer> nums = new LinkedList<Integer>();
        Arrays.sort(arr);
        for (int a : arr) {
            nums.add(Integer.valueOf(a));
        }
        while (nums.size() != 1) {
//            System.out.println("a : " + nums.getLast() + " / b : " + nums.get(nums.size() - 2));
            nums.add(getLcm(nums.pollLast(), nums.pollLast()));
        }
        
        answer = nums.getFirst();
//        System.out.println(answer);
        return answer;
    }

    public int getLcm(int a, int b) {
        int gcd = getGcd(a, b);
//        System.out.println("l :" + (a * b) / gcd);
        return (a * b) / gcd;
    }

    public int getGcd(int a, int b) {
        int r = -1;
        int num = a;
        int g = b;
        while (r != 0) {
            if (r != -1) {
                num = g;
                g = r;
            }
            r = num % g;
        }
//        System.out.println("g :" + g);
        return g;
    }
}