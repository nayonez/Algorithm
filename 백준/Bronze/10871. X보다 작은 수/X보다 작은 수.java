import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] intArr = new int[N];

        for (int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
            if(X > intArr[i]) {
                sb.append(intArr[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
