import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int N, M, nr, nc;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로의 크기 = 행
        M = Integer.parseInt(st.nextToken()); // 가로의 크기 = 열
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    map[i][j] = 0;
                } else if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            } sb.append("\n");
        }
        System.out.println(sb);
    }
    
    private static void bfs() {
        while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                for (int d = 0; d < 4; d++) {
                    nr = arr[0] + deltas[d][0];
                    nc = arr[1] + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] != -1) continue;

                    queue.offer(new int[]{nr,nc});
                    map[nr][nc] = map[arr[0]][arr[1]] + 1;

            }
        }
    }
}
