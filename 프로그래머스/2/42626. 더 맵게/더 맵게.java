import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2; // 오름차순
        });
        
        int answer = 0;
        
        for (int i : scoville) {
            pq.offer(i);
        }
        
        // 제일 작은게 K보다 작을때 반복
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            // 새로운음식 = 제일작은거 + (두번째작은거*2)
            int small1 = pq.poll();
            int small2 = pq.poll();
            
            pq.offer(small1 + (2*small2));
            // 새로운음식 만들었으면 count증가
            answer++;
        }         
        return answer;
    }
}