import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/14916 - 거스름돈
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 거스름돈 액수
        int coin = 0;
        while (n > 1) { // 1이면 2로도 못나누고 거스름돈 못주는 상태
            if (n % 5 == 0) { // 5원으로 딱맞게 떨어지면
                coin += n / 5; // 코인에 몫(동전 갯수)을 더하고
                n = n % 5; // n을 나머지값으로 변경
            } else { // 5로 나누어 떨어지지 않을 경우,
                n -= 2; // 2를 빼고
                coin++; // 코인 하나를 증가시킴 -> 그리고 다시 무한 반복
            }
        }
        if (n == 0) System.out.println(coin);
        else System.out.println(-1);
    }
}
