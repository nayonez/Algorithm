
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] intArrays = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            intArrays[i] = a;
        }
        Arrays.sort(intArrays);
        for (int i = 0; i < N; i++) {
            sb.append(intArrays[i]).append("\n");
        }
        System.out.println(sb);
    }
}
