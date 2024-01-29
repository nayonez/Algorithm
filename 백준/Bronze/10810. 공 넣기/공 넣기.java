import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 바구니 N개, 공을 넣을 횟수 M번
        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        int i, j, k = 0;
        // 바구니의 개수만큼
        int[] intArr = new int[N];

        for (int x = 0; x < M; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // i부터 j번 바구니까지 k번 번호가 적힌 공을 넣는다.
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // i부터 j번째 바구니배열에 공번호 넣는 반복문
            for (int y = i-1; y <= j-1; y++) {

                intArr[y] = k;

            }
        }
        for (int z = 0; z < intArr.length; z++) {
            sb.append(intArr[z]).append(" ");
        }
        System.out.println(sb);
    }
}
