import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int myLocation = location;

        Queue<Integer> orders = new LinkedList<>();
        PriorityQueue<Integer> printOrders = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            int p = Integer.valueOf(priority);
            orders.add(p);
            printOrders.add(p);
        }

        while (!orders.isEmpty()) {
            int first = orders.poll();
//            System.out.println("now : " + first);
//            System.out.println("max : " + printOrders.peek());
            if (first == printOrders.peek()) {
                answer++;
                printOrders.remove();
                if (myLocation == 0) {
                    break;
                } else {
                    myLocation--;
                }
            } else {
                orders.add(first);
                if (myLocation == 0) {
                    myLocation = orders.size() - 1;
                } else {
                    myLocation--;
                }
            }
//            System.out.println("me : " + myLocation);
//            System.out.println("!asr : " + answer);
        }

//        System.out.println(answer);

        return answer;
    }
}