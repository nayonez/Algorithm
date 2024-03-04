import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2577 - 숫자의 개수
public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ABC = 1;
        int[] ans = new int[10]; // 0부터 9까지 저장
        for (int i = 0; i < 3; i++) {
            ABC *= Integer.parseInt(br.readLine());
        }

        String s = String.valueOf(ABC);

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            ans[temp]++;
        }
        for (int c : ans) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}
