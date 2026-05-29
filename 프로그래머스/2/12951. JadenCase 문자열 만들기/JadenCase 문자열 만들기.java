import java.util.*;

class Solution {
    public String solution(String s) {
	String[] sArr = s.split(" ", -1);
	for (int i = 0; i < sArr.length; i++) sArr[i] = sArr[i].toLowerCase();
	for (int i = 0; i < sArr.length; i++) {
        if (sArr[i].isEmpty()) continue;
		if (sArr[i].charAt(0) >= 'a' && sArr[i].charAt(0) <= 'z') {
			char first = sArr[i].charAt(0);
			sArr[i] = sArr[i].replaceFirst(String.valueOf(first), String.valueOf(Character.toUpperCase(first)));
		}
	}
        return String.join(" ", sArr);
    }
}