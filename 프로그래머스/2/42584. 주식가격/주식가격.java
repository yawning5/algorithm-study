import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 자주 쓸거같은 길이는 변수에 할당
        int n = prices.length;
        // 답변 배열 생성
        int[] answer = new int[n];
        // 일단 stack 에 하나씩 넣고 빼자
        Deque<Integer> stack = new ArrayDeque<>();
        
        // prices 배열을 전체 순회
        for (int i = 0; i < n; i++) {
            
            // 2. 현재 저장할 금액이 이전 금액보다 낮다면 가격 하락 발생
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 조건문에서는 확인을 위한 peek
                // 조건이 참일땐 실제 작동을 위한 pop
                int idx = stack.pop();
                // stack 의 idx 가 떨어지기 까지 걸린 시간은
                // 현재 인덱스 - 해당 인덱스
                answer[idx] = i - idx;
            }
            
            // 1. 기본적으로 인덱스를 저장 -> 값은 원본배열에서 확인하기
            stack.push(i);
        }
                    // 끝까지 가격이 안 떨어져서 stack 에 남아있는 가격들
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                answer[idx] = (n - 1) - idx;
            }
        
        return answer;
    }
}