import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1978 - 소수 찾기
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            int temp = Integer.parseInt(st.nextToken());
            if (temp == 1) flag = false;
            else if (temp > 1) {
                for (int j = 2; j < temp; j++) { // 1과 자기자신을 제외한 모든 수로 나누어지지 않는다면 소수
                    if (temp % j == 0) { // 소수가 아님
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ans++;
        }
        System.out.println(ans);
    }
}
