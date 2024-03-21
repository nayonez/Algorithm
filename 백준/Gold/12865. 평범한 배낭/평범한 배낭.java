import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2]; // 열 -> 무게W, 가치V
        for (int i = 1; i <= N; i++) { // 아이템
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }
        int[][] dp = new int[N+1][K+1]; // 물품의 수N, 버틸수 있는 무게K
        int max1 = 0;
        int max2 = 0;
        for (int i = 1; i <= N; i++) { // 아이템 반복
            for (int j = 1; j <= K; j++) { // 무게 증가 K 까지
                // 버틸수 있는 무게j < 해당 아이템 무게
                if (j < arr[i][0]) { // 못넣는거
                    dp[i][j] = dp[i-1][j];
                } else if (j >= arr[i][0]) { // 내거 넣을 수 있을때 -> 1.넣는거 2.안넣는거
                    dp[i][j] = Math.max(dp[i-1][j - arr[i][0]] + arr[i][1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
