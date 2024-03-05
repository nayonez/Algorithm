import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            int[][] dp = new int[k+1][n+1]; // 층 호
            for (int j = 0; j < n+1; j++) {
                dp[0][j] = j; // 0층의 j호들은 j호만큼 산다
            }

            for (int r = 1; r <= k; r++) { // 층
                for (int c = 1; c <= n; c++) { // 호
                    dp[r][c] = dp[r][c-1] + dp[r-1][c]; // 같은층의 전 호 + 밑에층의 같은 호
                }
            }
            sb.append(dp[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
