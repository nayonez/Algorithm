import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 날의 수
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()); // 주가
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = arr[N-1]; // 맨 마지막 인덱스 max값
            long result = 0;
            for (int j = N-2; j >= 0; j--) { // 인덱스 거꾸로 확인! 맨 마지막 인덱스는 max값으로 빼둬서 비교x
                if (arr[j] <= max) {
                    result += max - arr[j];
                } else {
                    max = arr[j];
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
