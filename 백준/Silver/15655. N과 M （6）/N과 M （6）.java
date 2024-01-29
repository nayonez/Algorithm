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
        combination(0, 0);
        System.out.println(sb);
    }

    static void combination(int count, int start) {
        if (count == M) {
            for (int t : tgt) {
                sb.append(t).append(" ");
            } sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            tgt[count] = src[i];
            combination(count+1, i+1);
        }
    }
}