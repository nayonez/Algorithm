import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2908 - 상수
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 3자리 수
        int a100 = A / 100; // 100의 자리수=A를 100으로 나눈 몫
        int a10 = (A % 100) / 10; // 10의 자리수=A를 100으로 나눈 나머지에 10을 나눈 몫
        int a1 = (A % 100) % 10; // 1의 자리수
        A = (a1*100) + (a10*10) + (a100*1);

        int B = Integer.parseInt(st.nextToken()); // 3자리 수
        int b100 = B / 100; // 100의 자리수=A를 100으로 나눈 몫
        int b10 = (B % 100) / 10; // 10의 자리수=A를 100으로 나눈 나머지에 10을 나눈 몫
        int b1 = (B % 100) % 10; // 1의 자리수
        B = (b1*100) + (b10*10) + (b100*1);

        System.out.println(A>B ? A : B);
    }
}
