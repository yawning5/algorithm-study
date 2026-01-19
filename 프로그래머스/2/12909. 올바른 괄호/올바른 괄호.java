import java.util.*;
import java.util.stream.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int count = 0;
        
        for (char c : s.toCharArray()) {
             switch(c) {
                     case '(' -> count++;
                     case ')' -> count--;
             }
            if (count < 0) return false;                 
        }
        if (count > 0) return false;
        
        return answer;
    }
}