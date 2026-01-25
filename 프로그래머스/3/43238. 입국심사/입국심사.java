class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long max = 0;
        for (int t : times) {
            max = Math.max(max, t);
        }
        long right = max * n;
        
        while (left < right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }
            
            if (count >= n) {
                right = mid; // 가능 -> 줄이자
            } else {
                left = mid + 1; // 불가능 -> 늘리자
            }
        }
        return left;
    }
}