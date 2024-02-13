import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Node> queue = new ArrayDeque<>();
    static int deltas[][] = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
    static int count, N, M;
    static boolean[][] visited;
    static int[][] map;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로칸의 수 = 열 = C
        N = Integer.parseInt(st.nextToken()); // 세로칸의 수 = 행 = R
        count = 0;
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()); // 1 익음, 0 안익음, -1 토마토없음
                if (map[r][c] == 1) {
                    queue.offer(new Node(r,c));
                    visited[r][c] = true;
                }
            }
        }
        bfs();
        for (int r = 0; r < N && count != 0 ; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    count = 0;
                    break;
                }
            }
        }
        System.out.println(count-1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // 사방탐색
                for (int d = 0; d < 4; d++) {
                    int nr = node.r + deltas[d][0];
                    int nc = node.c + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc]==-1) continue;
                    queue.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
                    map[nr][nc] = 1;
                }
            } count++;
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
