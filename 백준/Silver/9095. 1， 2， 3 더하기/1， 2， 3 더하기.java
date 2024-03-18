import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];

            if (n >= 4) {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for (int j = 4; j <= n; j++) {
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                }
            }
            sb.append(n==1 ? 1 : n==2 ? 2 : n==3 ? 4 : dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
