import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean flag = true;
            ArrayDeque<Character> deque = new ArrayDeque();
            String s = br.readLine();
            if (s.equals("0")) break;
            for (int i = 0; i < s.length(); i++) {
                deque.offer(s.charAt(i));
            }
            int size = deque.size();
            while (!deque.isEmpty()) {
                if (!flag) break;
                if (size % 2 == 0) {
                    if (deque.peekFirst()==deque.peekLast()) {
                        deque.pollFirst();
                        deque.pollLast();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (size % 2 != 0) {
                    if (deque.size() == 1) break;
                    if (!flag) break;
                    int loop = size / 2;
                    for (int i = 0; i < loop; i++) {
                        if (deque.peekFirst()==deque.peekLast()) {
                            deque.pollFirst();
                            deque.pollLast();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
