import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        // Set 으로해서 종류 파악
        Set<Integer> types = 
            Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        
        // 선택가능한 마릿수 와 존재하는 종류 수 중 더 작은 값
        return Math.min(types.size(), nums.length / 2);
    }
}