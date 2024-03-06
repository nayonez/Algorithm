import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11399 - ATM
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 작은순으로 해야 최소가 됨 오름차순 정렬!
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N+1]; // 0번째에 0 주려고
        line[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 값을 다 입력받고
        for (int i = 1; i <= N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(line);
        // 값 갱신해주기
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            line[i] = line[i] + line[i-1];
            sum += line[i];
        }
        System.out.println(sum);
    }
}
