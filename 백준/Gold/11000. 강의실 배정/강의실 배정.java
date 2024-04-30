import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 개수
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        // pq에는 종료시간만 들어있다! pq의 사이즈가 회의실의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본이 오름차순

        for (Node node : arr) {
            // pq에 값이 들어있고 && pq에서 뽑은 종료시간이 지금 보는 노드의 시작시간보다 작으면, 현재 강의실에 이어서 배치 가능
            if (pq.size() > 0 && pq.peek() <= node.start) {
                pq.poll(); // pq에서 빼고
            }
            pq.offer(node.end); // 종료시간 넣어줌. 새 회의실이어도 동일
        }
        
        System.out.println(pq.size());
    }

    private static class Node implements Comparable<Node> {
        int start, end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start) { // 시작시간이 같다면
                return this.end - o.end; // 종료시간 오름차순
            }
            // 시작시간이 같지않으면 시작시간 오름차순
            return this.start - o.start;
        }
    }
}
