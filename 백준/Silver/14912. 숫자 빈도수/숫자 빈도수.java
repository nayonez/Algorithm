import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= n; i++) { // n 까지 돌면서 체크
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == d) count++; // 2자리수
                temp /= 10; // 다음자리수로
            }

        }
        System.out.println(count);
    }
}
