import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, sum, max;
    static int[] src, tgt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 카드의 개수
        M = Integer.parseInt(st.nextToken()); // 주어진 합! 이 값을 넘지 않게
        src = new int[N];
        tgt = new int[3]; // 3장의 합으로 주어짐
        max = Integer.MIN_VALUE;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st2.nextToken());
        }
        combination(0, 0);
        System.out.println(max);
    }
    static void combination(int count, int start) {
        sum = 0;
        if (count == 3) {

            for (int t : tgt) {
                sum += t;
            }
            if (sum > M) {
                return;
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = start; i < N; i++) {
            tgt[count] = src[i];
            combination(count + 1, i + 1);
        }
    }
}
