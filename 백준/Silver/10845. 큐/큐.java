import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 명령의 수
        Deque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push" : {
                    dq.offer(str[1]);
                    break;
                }
                case "pop" : {
                    if (dq.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dq.pollFirst()).append("\n");
                    break;
                }
                case "size" : {
                    sb.append(dq.size()).append("\n");
                    break;
                }
                case "empty" : {
                    if (dq.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                }
                case "front" : {
                    if (dq.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dq.peekFirst()).append("\n");
                    break;
                }
                case "back" : {
                    if (dq.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(dq.peekLast()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
