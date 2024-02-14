import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
        static boolean[][] map;
        static boolean[][] visited;
        static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
        static int M, N, count;


    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < T; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); 
            N = Integer.parseInt(st.nextToken()); 
            map = new boolean[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken()); 
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = true; 
            }
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!map[r][c] || visited[r][c]) continue;
//                    bfs(r,c);
                    dfs(r,c);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (!map[nr][nc] || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}
