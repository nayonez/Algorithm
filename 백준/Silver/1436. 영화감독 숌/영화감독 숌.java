import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = 666;
        while (N > 0) {
            int temp = number;
            while (temp >= 666) {
                if (temp % 1000 == 666) {
                    N--;
                    break;
                } else temp /= 10;
            }
            number++;
        }
        System.out.println(--number);
    }
}
