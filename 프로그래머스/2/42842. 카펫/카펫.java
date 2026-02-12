class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int by = brown + yellow;
        int b, y;
        
        
        for (int i = 1; i < by; i++) {
            if (by % i == 0) {
                b = Math.max(i , by / i);
                y = Math.min(i , by / i);
                if ((b - 2) * (y - 2) == yellow) {
                answer[0] = b;
                answer[1] = y;
            }
            }
        }
        
        return answer;
    }
}