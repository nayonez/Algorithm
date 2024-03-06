import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5585 - 거스름돈
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - Integer.parseInt(br.readLine()); // 거스름돈 = 10000원 냈고 - 제품가격
        int[] change = {500, 100, 50, 10, 5, 1}; // 잔돈 배열 = 배수다 --> 큰 걸로 나눠야 무조건 적은 수다.
        int coin = 0;
         // money가 0 되면 끝
        for (int i = 0; i < change.length || money > 0; i++) {
            if (money >= change[i]) {
                coin += money / change[i]; // money를 갱신하기 전에 잔돈을 처리 해주기.
                money = money % change[i]; // 나머지가 갱신할 money가 되고, 몫이 누적할 동전개수가 된다.
            }
        }
        System.out.println(coin);
    }
}
