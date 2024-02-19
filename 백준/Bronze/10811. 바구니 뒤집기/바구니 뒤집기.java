import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니에는 1번부터 N번까지 번호가 적혀있다.
        int M = Integer.parseInt(st.nextToken()); // 순서를 역순으로 바꿀 횟수
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            int temp = 0;
            Collections.reverse(list.subList(start, end));
        }
        for (Integer l : list) {
            sb.append(l).append(" ");
        }
        System.out.println(sb);
    }
}
