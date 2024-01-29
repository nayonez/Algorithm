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
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st1.nextToken());
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
