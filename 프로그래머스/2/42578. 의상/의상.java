import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 카테고리 별 key 를 만들고 string, integer 맵에 저장해서 조합으로 계산
        Map<String, Integer> map = new HashMap<>();
        for (String [] clothe : clothes) {
            map.merge(clothe[1], 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        return answer - 1;
    }
}