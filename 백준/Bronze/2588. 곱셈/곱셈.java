import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int n1 = num2 / 100;
        int n2 = (num2 % 100) / 10;
        int n3 = (num2 % 100) % 10;
        sb.append(num * n3).append("\n").append(num * n2).append("\n").append(num * n1).append("\n").append(num * num2);
        System.out.println(sb);
    }
}
