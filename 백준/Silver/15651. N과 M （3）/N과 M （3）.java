import java.io.*;
import java.util.*;

public class Main {
        static int[] src, tgt;
        static int N, M;
        static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        tgt = new int[M];
        for (int i = 0; i < N; i++) {
            src[i] = i + 1;
        }
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int count) {
        // 재귀 멈출 조건
        if (count == M) {
            for (int t : tgt) {
                sb.append(t).append(" ");
            } sb.append("\n");
            return;
        }

        // 재귀 내용
        for (int i = 0; i < N; i++) {
            tgt[count] = src[i];
            permutation(count + 1);
        }
    }
}
