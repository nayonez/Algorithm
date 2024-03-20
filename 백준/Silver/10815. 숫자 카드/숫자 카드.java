import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드의 개수
        boolean[] card = new boolean[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            card[Integer.parseInt(st.nextToken())+10000000] = true;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(card[Integer.parseInt(st.nextToken())+ 10000000] ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
