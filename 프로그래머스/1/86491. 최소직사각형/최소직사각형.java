import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int l = 0;
        int h = 0;
        
        for (int[] size : sizes) {
            Arrays.sort(size);
            
            l = Math.max(size[0], l);
            h = Math.max(size[1], h);
        }
            answer = l*h;
        return answer;
    }
}