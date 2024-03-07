import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Ai는 Ai-1의 배수 -> 큰 값에서부터 처리해야함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 주어진 동전으로 K를 0으로.(0이 아닌 경우는 주어지지 않음)
        int[] coin = new int[N];
        int count = 0;
        // 큰 단위부터 저장함
        for (int i = 1; i <= N; i++) { // 10이면 인덱스 0~9까지 저장됨
            coin[N-i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < coin.length || K > 0; i++) {
            if (K >= coin[i]) {
                count += K / coin[i];
                K = K % coin[i];
            }
        }
        System.out.println(count);
    }
}
