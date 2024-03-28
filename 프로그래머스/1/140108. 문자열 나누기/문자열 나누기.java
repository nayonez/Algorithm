import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int same = 0;  // 첫 글자 자체가 1 이니까
        int diff = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (first == s.charAt(i)) {
                same++;
            } else { // 다르면
                diff++;
            }
            if (same == diff) {
                answer++;
                if (i+1 < s.length()) {
                    first = s.charAt(i+1);
                }
                same = 0;
                diff = 0;
            } else if (i == s.length()-1) { // 인덱스가 같을 때
                answer++; // 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
            }
        }
        return answer;
    }
}