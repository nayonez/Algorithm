import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[N];

        for(int i = 0; i < N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Arrays.stream(intArr).min().getAsInt();
        int max = Arrays.stream(intArr).max().getAsInt();

        sb.append(min).append(" ").append(max);
        System.out.println(sb);

    }
}
