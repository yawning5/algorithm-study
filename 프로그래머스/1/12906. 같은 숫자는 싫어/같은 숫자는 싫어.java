import java.util.*;
import java.util.stream.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        // 선입 선출 구조로 들어간 숫자를 변수에 저장한 뒤 다른 숫자가 오기 전까지 넣지 않고
        Deque<Integer> q = new ArrayDeque<>();
        // 다른 숫자가 오면 넣은 뒤 변수값 변경시키기
        // 이후 큐 qoll 해서 answer 에 넣고 배열변환
        int cur;
        q.add(arr[0]);
        for (int i : arr) {
            cur = q.getLast();
            if (cur != i) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            answer.add(q.poll());
        }
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}