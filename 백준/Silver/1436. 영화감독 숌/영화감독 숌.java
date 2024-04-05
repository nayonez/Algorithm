import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = 666;
        while (N > 0) {
            if (String.valueOf(number).contains("666")) {
                N--;
            }
            number++;
        }
        System.out.println(--number);
    }
}
