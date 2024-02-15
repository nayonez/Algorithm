import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] deltas = {{-1,-1}, {-1,0}, {1,1}, {1,0}, {-1, 1}, {0,-1}, {1,-1}, {0,1}};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N][M];
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) continue;
                bfs(r, c, map[r][c]);
                if (flag)
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(int r, int c, int height) {
        flag = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nr = temp[0] + deltas[d][0];
                int nc = temp[1] + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] > height) // 인접한 게 현재높이보다 클때->산봉우리가 아님
                    flag = false;
                if (visited[nr][nc]) continue;
                if (map[nr][nc]!=height) continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
