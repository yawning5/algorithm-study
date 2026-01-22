import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 저장
        
        for (int i = 0; i < n; i++) {
            
            // 가격이 떨어지는 순간 처리
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            
            // 현재 인덱스 스택에 저장
            stack.push(i);
        }
        
        // 끝까지 안 떨어진 경우 처리
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (n - 1) - idx;
        }
        
        return answer;
    }
}