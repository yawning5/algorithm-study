// 대각선은 시작 칸 1개에서 출발해서, 격자선을 넘을 때마다 새 칸으로 1개씩 진입한다.

import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        return (long) w * h - (w + h - gdc(w, h));
    }

	private static int gdc(int a, int b) {
		while(b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}