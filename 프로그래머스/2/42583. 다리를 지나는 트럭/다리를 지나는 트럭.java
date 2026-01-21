import java.util.*;

class Solution {    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> trucks = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            trucks.offer(0);
        }
        int answer = 0;
        int idx = 0;
        
        while(trucks.size() != 0) {
            answer++;
            weight += trucks.poll();
            if (idx >= truck_weights.length) {continue;}
            if (weight - truck_weights[idx] >= 0) {
                weight -= truck_weights[idx];
                trucks.offer(truck_weights[idx]);
                idx++;
            } else {
                trucks.offer(0);
            }
        }
        
        return answer;
    }
}