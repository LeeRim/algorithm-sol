import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        LinkedList<String> partList = new LinkedList<>();
        for (int i = 0; i < participant.length; i++) {
            partList.add(participant[i]);
        }

        partList.sort(Comparator.naturalOrder());
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (partList.contains(completion[i])) {
                partList.remove(completion[i]);
            }
        }

//        System.out.println(partList);
        return partList.get(0);
    }
}