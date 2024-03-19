import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1]; // 각 포도주 양
        int[] dp = new int[n+1]; // 누적 포도주 최댓값
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = dp[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max( // 3개 연속 마실 수 없고, 마지막 포함해야되는 조건 없으니까 그냥 최댓값 구해야함
                        Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]), dp[i-1]);
            // dp[i-1] = 바로 앞의 누적값이랑 현재 idx의 누적값이랑 비교해서 앞에 누적이 더 클수도 있음 그럼 변경해주기
        }
        System.out.println(dp[n]);
    }
}
