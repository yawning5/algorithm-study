class Solution {
    public String solution(String s) {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	
	for (String token : s.split(" ")) {
		int n = Integer.parseInt(token);
		min = Math.min(min, n);
		max = Math.max(max, n);
	}

        return min + " " + max;
    }
}