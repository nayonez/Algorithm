import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14215 - 세 막대
public class Main {
    // 삼각형의 조건 = 두 변의 합 > 한 변
    // 이 말은 곧 -> 제일 긴 한 변 < 다른 두 변의 합
    public static void main(String[] args) throws Exception {
        int[] src = new int[3];
        int[] tgt = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = 0;
        sum = a + b + c;
        int max = Integer.MIN_VALUE;
        max = Math.max(a,b);
        max = Math.max(max, c);

        while (true) {
            if (max < sum - max) {
                System.out.println(sum);
                break;
            }
            else {
                max--;
                sum--;
            }
        }
    }

}
