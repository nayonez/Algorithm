import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정수 n의 개수
        int k = Integer.parseInt(st.nextToken()); // 연속적인 k일
        int[] arr = new int[n]; // 0 ~ n-1 인덱스
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i]; // 0부터 첫번째 구간까지의 합
        }

        int answer = sum;

        for (int i = 1; i <= n - k; i++) {
            sum = sum - arr[i-1] + arr[i+k-1];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
