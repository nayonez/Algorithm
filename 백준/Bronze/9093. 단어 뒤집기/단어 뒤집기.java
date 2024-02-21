import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                StringBuilder sb1 = new StringBuilder();
                String s = st.nextToken();
                sb1.append(s);
                sb.append(sb1.reverse()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
