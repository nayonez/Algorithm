import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        // 회의 종료시간 기준으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int count = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= arr[i][0]) { // 끝나는 시간이 다음회의 시작할 시간[i][0] 보다 작거나 같으면 배치 가능
                count++;
                end = arr[i][1];
            }
        }
        System.out.println(count);
    }
}
