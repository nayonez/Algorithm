import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2167 - 이차원 배열의 합
public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum;
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int map[][] = new int[N][M];
        // 행열 데이터 입력받음
        for (int i = 0; i < N; i++) { // i행
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) { // j열
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            // i,j,x,y순 = i행,j열 = (1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M)
            // 행 = j = y
            int startR = Integer.parseInt(st.nextToken()) - 1; // i 행
            int startC = Integer.parseInt(st.nextToken()) - 1; // j 열
            int endR = Integer.parseInt(st.nextToken()) - 1; // x 행
            int endC = Integer.parseInt(st.nextToken()) - 1; // y 열

            for (int r = startR; r <= endR; r++) {
                for (int c = startC; c <= endC; c++) {
                    sum += map[r][c];
                }
            } sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
