import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> work = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            // work.offer((100 - progresses[i]) / speeds[i]);
            work.offer((100 - progresses[i] + speeds[i] - 1) / speeds[i]);
        }
        
        int cur = work.poll();
        int l = 0;
        while(work.size() != 0) {
            l++;
            Integer next = work.poll();
            if (cur < next) {
                answer.add(l);
                cur = next;
                l = 0;
            }
        }
        answer.add(l + 1);
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}