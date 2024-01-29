import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 바구니 N개, 공을 바꿀 횟수 M번
        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        int i, j, k = 0;
        // 바구니의 개수만큼
        int[] intArr = new int[N];
        int temp = 0;

        // 각 바구니의 공번호 동일하게 초기세팅(공은 1개임)
        for (int a = 0; a < N; a++) {
            intArr[a] = a + 1;
        }

        for (int x = 0; x < M; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // i와 j 바구니의 공을 바꾼다. k는 공의 번호
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            temp = intArr[i - 1];
            intArr[i - 1] = intArr[j - 1];
            intArr[j - 1] = temp;
        }

        for (int y = 0; y < intArr.length; y++) {
            sb.append(intArr[y]).append(" ");
        }
        System.out.println(sb);
    }
}
