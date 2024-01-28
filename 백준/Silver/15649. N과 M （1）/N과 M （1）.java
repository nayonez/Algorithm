import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] src, tgt;
    static boolean[] used;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        tgt = new int[M];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            src[i] = i + 1;
        }
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int count) {
        // 재귀를 끝낼 조건
        if (count == M) {
            for (int t : tgt) {
                sb.append(t).append(" ");
            } sb.append("\n");
//            System.out.println(sb);
            return;
        }

        // 재귀 내용
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            tgt[count] = src[i];
            used[i] = true;
            permutation(count + 1);

            used[i] = false;
        }
    }
}
