import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/10162 - 전자레인지
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] btn = {300, 60, 10}; // 배수이므로.. 큰값으로 하는게 무조건 최소
        int T = Integer.parseInt(br.readLine()); // 요리해야될 T초

        int count = 0; // 각 초수마다의 카운트. 누적X
        for (int i = 0; i < btn.length; i++) {
            if (T >= btn[i]) {
                count = T / btn[i];
                sb.append(count).append(" ");
                T = T % btn[i];
            } else {
                sb.append(0).append(" ");
            }
            if (0 < T && T < 10) break;
        }
        if (T > 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
