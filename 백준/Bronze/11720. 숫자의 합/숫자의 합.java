import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] c = new char[N];
        int sum = 0;
        c = br.readLine().toCharArray();
        for(int i = 0; i < N; i++) {
            sum += c[i]-'0';
        }
        System.out.println(sum);
    }
}