import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        //progresses[]를 개발이 완료 가능한 = 100%되는 날짜로 변경
        for (int i = 0; i < speeds.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                // 나머지가 없다면
                queue.offer((100 - progresses[i] ) / speeds[i]);
            } else { // 나머지가 있다면
                queue.offer(((100 - progresses[i] ) / speeds[i]) + 1);
            }
        }
        
        int ans = 0;
        int count = 1; // poll한 것과 같이 뺄 수 있는 거 카운트
        int temp = queue.poll();
        
        while(!queue.isEmpty()) {
            if (temp >= queue.peek()) {
                queue.poll();
                count++;
            } else { // 나보다 더 큰 애가 나왔을때
                temp = queue.poll();
                answer.add(count);
                count = 1;
            }
        } answer.add(count);
        
        return answer;
    }
}