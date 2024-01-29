import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] src, tgt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        tgt = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(src);
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int count) {
        if (count == M) {
            for (int t : tgt) {
                sb.append(t).append(" ");
            } sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            tgt[count] = src[i];
            permutation(count + 1);
        }
    }
}
