import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int R = 0;
        char[] c = new char[20];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            c = st.nextToken().toCharArray();
            for (int j = 0; j < c.length; j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(c[j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
