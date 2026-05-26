import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
	String answer = "";
	Map<String, Integer> man = new HashMap<String, Integer>();
	for (String p : participant) {
		man.merge(p, 1, Integer::sum);
	}
	for (String c : completion) {
		man.computeIfPresent(c, (k, v) -> v - 1);
	}
	for (var eSet : man.entrySet()) {
		if (eSet.getValue() != 0) return eSet.getKey();
        }
        return null;
    }
}