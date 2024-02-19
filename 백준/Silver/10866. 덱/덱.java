import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        Deque<String> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push_front" : {
                    deque.addFirst(str[1]);
                    break;
                }
                case "push_back" : {
                    deque.addLast(str[1]);
                    break;
                }
                case "pop_front" : {
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    } break;
                }
                case "pop_back" : {
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    } break;
                }
                case "size" : {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case "empty" : {
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    } break;
                }
                case "front" : {
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    } break;
                }
                case "back" : {
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    } break;
                }
            }
        } System.out.println(sb);
    }
}
