import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(String.valueOf(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
