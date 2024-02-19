import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] map;
    static int count, N, M, day;
    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = 0;
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Node(i,j));
                }
            }
        }
        bfs();
        day = 0;
        System.out.println(ans());

    }
    private static int ans() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] > 0) {
                    day = Math.max(day, map[r][c]);
                }
                if (map[r][c] == 0) {
                    return -1; // 안익은 토마토가 한개라도 있으면 -1
                }
            }
        } return day - 1;
    }
    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + deltas[d][0];
                int nc = node.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == -1) continue;
                if (map[nr][nc] == 0) {
                    map[nr][nc] = map[node.r][node.c] + 1;
                    queue.offer(new Node(nr, nc));
                }
            }
        }
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
