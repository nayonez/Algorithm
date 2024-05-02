import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 단원 개수
        int T = Integer.parseInt(st.nextToken()); // 공부할수 있는 총 시간
        int[][] arr = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 각 단원 별 예상 공부 시간 K = 무게
            arr[i][0] = Integer.parseInt(st.nextToken());
            // 그 단원 문제의 배점 S = 가치
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][T+1];
        for (int i = 1; i <= N; i++) { // 단원 개수만큼
            for (int j = 1; j <= T; j++) { // 총 시간까지
                if (arr[i][0] > j) {
                    dp[i][j] = dp[i-1][j]; // 못넣는경우는 전에거
                }
                else if (arr[i][0] <= j) { // 들어갈 수 있는 경우
                    // 넣거나 안넣거나
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
        }
        System.out.println(dp[N][T]);
    }
}
