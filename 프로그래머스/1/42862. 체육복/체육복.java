import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
	int good = n - lost.length;
	Set<Integer> res = new HashSet<>();
	Arrays.sort(lost);
	for (int i : reserve) res.add(i);

	for (int i = 0; i < lost.length; i++) {
		if (res.contains(lost[i])) {
			res.remove(lost[i]);
			lost[i] = -1;
			// 여분을 가져온 사람이 도난당한 경우를 처리할때 good 에 + 1 을 해주지 않았었음
			good += 1;
		}
	}

	for (int l : lost) {
		if (l > 0) {
			if (res.contains(l -1)) {
				res.remove(l - 1);
				good += 1;
			} else if (res.contains(l + 1)) {
				res.remove(l + 1);
				good += 1;
			}
		}
	}
		
        return good;
    }
}