import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1937 - 욕심쟁이 판다
public class Main {
    static int n;
    static int[][] dp, arr;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    max = Math.max(max, dfs(i,j));
                }
            }
        }
        System.out.println(max);

    }
    private static int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];
        dp[r][c] = 1; // visited 체크
        // 4방 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (arr[r][c] >= arr[nr][nc]) continue; // 현재위치 >= 이동할위치면 탐색x(더 큰곳으로만 이동가능)
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        return dp[r][c];
    }
}
