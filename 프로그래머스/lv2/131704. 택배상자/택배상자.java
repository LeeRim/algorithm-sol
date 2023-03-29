import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int cnt = 0;

        Stack<Integer> 보조 = new Stack<>();

        for(int i=0; i<order.length; i++){
            보조.add(i+1);

            while(!보조.isEmpty()){
                if(보조.peek() == order[cnt]){
                    보조.pop();
                    cnt++;
                }else break;

            }
        }
        return cnt;
    }
}