import java.util.*;
import java.util.stream.*;

class Solution {
    
    private class Task{
        int pri;
        int loc;
        
        Task(int pri, int loc) {
            this.pri = pri;
            this.loc = loc;
        }
    }
    
    
    public int solution(int[] priorities, int location) {
        Deque<Task> tasks = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            tasks.offer(new Task(priorities[i], i));
        }        
        
        Arrays.sort(priorities);
        
        int idx = priorities.length - 1;
        int p = 0;
        
        while (!tasks.isEmpty()) {
            Task task = tasks.poll();
            
            if (task.pri == priorities[idx]) {
                if (task.loc == location) {
                    return p + 1;
                }
                p++;
                idx--;
            } else {
                tasks.offer(task);
            }
        }
        
        return p + 1;
    }
}