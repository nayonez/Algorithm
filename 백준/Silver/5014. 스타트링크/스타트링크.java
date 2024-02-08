import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, g, u, d, count;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = 0;
        f = Integer.parseInt(st.nextToken()); // 건물의 최고층
        int s = Integer.parseInt(st.nextToken()); // 내 현재 위치
        g = Integer.parseInt(st.nextToken()); // 내 목적지
        u = Integer.parseInt(st.nextToken()); // u칸만큼 위로
        d = Integer.parseInt(st.nextToken()); // d칸만큼 아래로

        int[] floor = new int[f + 1]; // 건물은 1층부터 f층까지
        visited = new boolean[f + 1];

        if (bfs(s) == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(count);
        }
    }

    public static int bfs(int s) {
        int[] deltas = {+u, -d};
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp == g) {
                    return count;
                }
                for (int d = 0; d < 2; d++) {
                    int nf = temp + deltas[d];
                    if (nf <= 0 || nf > f)
                        continue;
                    if (visited[nf])
                        continue;
                    queue.offer(nf);
                    visited[nf] = true;
                }
            }
            count++;
        }
        return -1;
    }
}
