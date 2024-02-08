
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        System.out.println(count);

    }

    private static void bfs(int N) {
        count = 0;
        boolean[] visited = new boolean[100001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp == K)
                    return;
                int[] deltas = {-1, 1, temp};
                // 탐색
                for (int d = 0; d < 3; d++) {
                    int nn = temp + deltas[d];
                    if (nn < 0 || nn > 100000)
                        continue;
                    if (visited[nn])
                        continue;
                    queue.offer(nn);
                    visited[nn] = true;
                }
            }
            count++;
        }
    }

}
