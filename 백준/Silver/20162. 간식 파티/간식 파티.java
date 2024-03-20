import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/20162 - 간식 파티
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            // 평점은 모두 100,000을 넘지 않는 양의 정수이다.
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            } max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
