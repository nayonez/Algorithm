import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 전체 일 수
        int x = Integer.parseInt(st.nextToken()); // 구간 일 수
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        int sum = 0;

        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int answer = sum;

        for (int i = 1; i <= n-x; i++) {
            sum = sum - arr[i-1] + arr[i+x-1];
            if (answer == sum) {
                count++;
            }
            else if (sum > answer){
                answer = sum;
                count = 1; // 초기화
            }
        }
        if (answer == 0) System.out.println("SAD");
        else {
            System.out.println(answer);
            System.out.println(count);
        }
    }
}
