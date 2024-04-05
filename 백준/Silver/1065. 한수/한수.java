import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        if (N <= 99) {
            System.out.println(N);
            return;
        }

        count = 99; // 99까지는 다 일정한 수열
        for (int i = 100; i <= N; i++) { // 99까진 계산했고 100부터 N까지 1씩 증가하면서 확인
            int a = i / 100; // 100의 자리수
            int b = (i % 100) / 10; // 10의 자리수
            int c = (i % 100) % 10; // 1의 자리수

            if (a-b == b-c) {
                count++;
            }
        }
        System.out.println(count);
    }
}
