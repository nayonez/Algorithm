import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // stack -> peek / pop 하기 전에 isEmpty 확인 먼저
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    sb.append(queue.poll()).append(", ");
                } else {
                    queue.offer(queue.poll());
                }
            }
        }
        // sb.delete(여기부터, 여기전까지) 삭제
        sb.delete(sb.length()-2, sb.length()).append(">");
        System.out.println(sb);
    }
}