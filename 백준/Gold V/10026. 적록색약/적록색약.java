import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N, count;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // 적록색약이 아닌 사람
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) continue;
//                bfs(r,c,map[r][c]);
                dfs(r,c,map[r][c]);
                count++;
            }
        } sb.append(count).append(" ");

        // 적록색약인 사람
        count = 0;
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 'R')
                    map[r][c] = 'G';
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) continue;
//                bfs(r,c,map[r][c]);
                dfs(r,c,map[r][c]);
                count++;
            }
        } sb.append(count);

        System.out.println(sb);
    }

    private static void dfs(int r, int c, char color) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (visited[nr][nc]) continue;
            if (color!=map[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc, map[nr][nc]);
        }
    }
}
