import java.util.*;

class Solution {
    public String solution(int n) {
        int[] rule = {1, 2, 4};
//	int[] rawA = new int[(int)(Math.log(n) / Math.log(3)) + 1];
        
        int len = 1;
        while ((Math.pow(3, len + 1) - 3) / 2 < n) len++;
        int[] rawA = new int[len];
        
	Arrays.fill(rawA, 1);

	int target = n - (int)((Math.pow(3, len) - 1) / 2);



	for (int i = rawA.length - 1; i >= 0; i--) {
		int cur = (int) Math.pow(3, i);
		rawA[i] += target / cur;
		target = target % cur;
	}

	var sb = new StringBuilder();
for (int i = len - 1; i >= 0; i--) sb.append(rule[rawA[i] - 1]);    
        return sb.toString();
    }
}