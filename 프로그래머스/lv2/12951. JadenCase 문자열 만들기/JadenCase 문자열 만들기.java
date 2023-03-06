class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        char before = ' ';
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (before == ' ') {
                if (Character.isLetter(now)) {
                    sb.append(Character.toUpperCase(now));
                } else {
                    sb.append(now);
                }
            } else {
                sb.append(Character.toLowerCase(now));
            }

            before = now;
        }

        return sb.toString();
    }
}