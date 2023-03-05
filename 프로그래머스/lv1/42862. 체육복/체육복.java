import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserves = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toSet());
        int[] lostAll = Arrays.stream(lost).sorted().filter(l -> {
            if (reserves.remove(l)) {
                return false;
            }
            return true;
        }).toArray();

        long lostCnt = Arrays.stream(lostAll).filter(l -> {
            if (reserves.remove(l-1) || reserves.remove(l+1)) {
                return false;
            }
            return true;
        }).count();

        System.out.println(lostCnt);
        int answer = n - (int) lostCnt;
        return answer;
    }
}