import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수
        HashSet<String> set = new HashSet<>();
        ArrayList<String> li = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            if (set.contains(temp)) {
                li.add(temp);
                count++;
            }
        }

        Collections.sort(li);
        System.out.println(count);
        for (String s : li) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
