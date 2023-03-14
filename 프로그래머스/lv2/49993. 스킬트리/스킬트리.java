class Solution {
    public int solution(String skill, String[] skill_trees) {

        int count = 0;
        boolean right;
        int index, skIndex;
        for (String skillTree : skill_trees) {
            right = true;
            index = 0;
            for (int i = 0; i < skill.length(); i++) {
                skIndex = skillTree.indexOf(skill.charAt(i));
                if (skIndex == -1) {
                    index = 27;
                    continue;
                }
                if ((index == -1 && skIndex > index) || skIndex < index) {
                    right = false;
                    break;
                }
                index = skIndex;
            }
            if (right) {
                count++;
            }
        }

        return count;
    }
}