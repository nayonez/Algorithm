import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] str = new String[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();
            str[i][1] = st.nextToken();
        }
        Arrays.sort(str, ((o1, o2) -> {
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        }));

        for (String[] string : str) {
            sb.append(string[0]).append(" ").append(string[1]).append("\n");
        }
        System.out.println(sb);
    }
}