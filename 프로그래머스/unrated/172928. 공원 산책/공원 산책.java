import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Map<Character, Integer> direction;
    public int[] solution(String[] park, String[] routes) {
        direction = new HashMap<>();
        direction.put('N', 0);
        direction.put('S', 1);
        direction.put('W', 2);
        direction.put('E', 3);
        
        int[] start = new int[2];
        start[0] = -1;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
            if (start[0] >= 0) {
                break;
            }
        }
        
        int[] point = start;
        for(int i = 0; i < routes.length; i++) {
            start = move(park, point, routes[i]);
            if (start == null){
                continue;
            }
            point = start;
        }
        
        return point;
    }
    
    public int[] move(String[] park, int[] start, String command){
        int[] point = start.clone();
        int dIndex = direction.get(command.charAt(0));
        int count = command.charAt(2) - '0';
        // System.out.println("start" + Arrays.toString(point));
        
        for(int i = 0; i < count; i++){
            point[0] += dx[dIndex];
            point[1] += dy[dIndex];
            // System.out.println(Arrays.toString(point));
            
            if(point[0] < 0 || point[1] < 0 || point[0] >= park.length ||point[1] >= park[0].length()){
                return null;
            }
            if(park[point[0]].charAt(point[1]) == 'X') {
                return null;
            }
        }
        
        // System.out.println("return" + Arrays.toString(point));
        return point;
    }
} 