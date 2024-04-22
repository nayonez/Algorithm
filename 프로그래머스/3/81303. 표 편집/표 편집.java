import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (String s : cmd) {
            switch (s.charAt(0)) {
                case 'U' : 
                    k -= Integer.parseInt(s.split(" ")[1]);
                    break;
                
                case 'D' : 
                    k += Integer.parseInt(s.split(" ")[1]);
                    break;
                
                case 'C' : 
                    stack.push(k); // 삭제된 행의 인덱스를 스택에 추가
                    n--;
                    if (k==n) k--; // 마지막 행이라면 선택된 행 하나 위로 변경!
                    break;
                
                case 'Z' : 
                    n++;
                    if (stack.pop() <= k) k++;
                    break;
            } // switch 
      } // for
        sb.append("O".repeat(Math.max(0, n)));
            while (!stack.isEmpty()) {
                sb.insert(stack.pop(), "X");
            }
        return sb.toString();
    }
}