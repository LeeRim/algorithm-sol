class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for (String skillTree : skill_trees) {
            int precedenceIndex = -1;
            int next = 0;
            boolean isRight = true;
            for (int i = 0; i < skill.length(); i++) {
                for (int j = 0; j < skillTree.length(); j++) {
                    if (skill.charAt(i) == skillTree.charAt(j)) {
                        if (precedenceIndex > j
                        || next < i) {
                            isRight = false;
                            break;
                        }
                        precedenceIndex = j;
                        next++;
                        break;
                    }
                }
                if (!isRight) {
                    break;
                }
            }
            if (isRight) {
                count++;
            }
        }
//        System.out.println(count);
        return count;
    }
}