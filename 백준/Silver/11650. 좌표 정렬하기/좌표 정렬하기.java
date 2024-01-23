import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 1; j++) {
                arr[i][j] = xi;
                arr[i][j+1] = yi;
            }
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });


        for (int[] array : arr) {
            for (int a : array) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}