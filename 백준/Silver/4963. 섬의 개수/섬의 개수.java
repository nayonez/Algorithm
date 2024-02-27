import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4963 - 섬의 개수
public class Main {
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}, {1,-1}, {1,1}, {-1,-1}, {-1,1}};
    static boolean[][] visited;
    static int[][] map;
    static int w, h, count;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 지도의 너비 = 열
            h = Integer.parseInt(st.nextToken()); // 지도의 높이 = 행
            if (w==0 && h==0) break;
            count = 0;
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (map[r][c]==0) continue;
                    if (visited[r][c]) continue;
                    bfs(r,c);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nr = temp[0] + deltas[d][0];
                int nc = temp[1] + deltas[d][1];
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (map[nr][nc]==0) continue;
                if (visited[nr][nc]) continue;
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
