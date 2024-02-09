import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] safe;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;
        int max = 0;
        N = Integer.parseInt(br.readLine()); // 행, 열, N미만이면 물에 잠김
        map = new int[N][N];
        safe = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int n = 0; n <= 100; n++) { // 높이 별로 안전 영역 탐색
            safe = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (safe[i][j])
                        continue;
                    if (map[i][j] <= n)
                        continue;
                    bfs(i, j, n);
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void bfs(int r, int c, int n) {
        int[][]deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c));
        safe[r][c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;
                if (safe[nr][nc])
                    continue;
                if (map[nr][nc] <= n)
                    continue;
                queue.offer(new Node(nr,nc));
                safe[nr][nc] = true;
            }
        }
    }

    public static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
