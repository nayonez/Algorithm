import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);
        }
        System.out.println(queue.peek());
    }
}