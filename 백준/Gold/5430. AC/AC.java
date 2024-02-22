import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            // 명령 하나씩 자르기
            boolean flagReverse = false; // true면 R만나서 반대 된것, false일땐 앞에서 삭제 true일땐 뒤에서 삭제
            String s = br.readLine();
            boolean error = false;
            Deque<Integer> deque = new ArrayDeque<>();
            char[] p = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                p[j] = s.charAt(j); // 명령 한글자씩 p에 삽입
            }
            int n = Integer.parseInt(br.readLine()); // 배열 크기
            String x = br.readLine();
            StringTokenizer st = new StringTokenizer(x, "[],"); // [ ] , 세개로 끊어서 저장! 얘네는 st에 포함 안되는 문자들
            while (st.hasMoreTokens()) {
                deque.offer(Integer.parseInt(st.nextToken())); // deque에 배열 값 넣었음
            }

            for (int j = 0; j < p.length; j++) {
                if (p[j] == 'R') {
                    flagReverse = !flagReverse;
                } else { // 삭제하는거면 'D'
                    if (!deque.isEmpty()) {
                        if (flagReverse) { // true면 반대인것 뒤에서 삭제
                            deque.pollLast();
                        } else { // false면 원래대로 앞에서
                            deque.pollFirst();
                        }
                    } else {
                        error = true;
                        sb.append("error").append("\n");
                        break;
                    }
                }
            }
            if (!error) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(flagReverse ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
