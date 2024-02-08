import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int A, B = 0;
        String input = "";

        while (((input = br.readLine()) != null)) {
            st = new StringTokenizer(input);
            if (st.hasMoreTokens()) {
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                sb.append(A+B).append("\n");
            }
        }
        System.out.println(sb);
    }
}
