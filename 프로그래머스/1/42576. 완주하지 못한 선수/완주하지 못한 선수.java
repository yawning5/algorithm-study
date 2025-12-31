import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 지원자 배열을 다 돌면서 K = 참가자 이름, V = 참가자 수 Map 을 만듬
        Map<String, Integer> all = new HashMap<>();
        
        for (String p : participant) {
            all.merge(p, 1, Integer::sum);
        }
        // 완료자 배열을 돌면서 V - 1 을 함
        for (String c : completion) {
            all.merge(c, -1, Integer::sum);
        }
        
        // 완료자 배열을 돌면서 V != 0 인 참가자 이름을 뱉음
        for (Map.Entry<String, Integer> entry : all.entrySet()) {
            if (entry.getValue() != 0)
                return entry.getKey();
        }
        
        return null;
    }
}