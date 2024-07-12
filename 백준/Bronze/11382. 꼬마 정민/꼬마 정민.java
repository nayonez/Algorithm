import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long ans = 0L;

        for (int i = 0; i < 3; i++) {
            ans += Long.parseLong(st.nextToken());
        }
        System.out.println(ans);
    }
}
