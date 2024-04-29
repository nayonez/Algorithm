import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long count = 0;
        int N = Integer.parseInt(br.readLine()); // 빌딩개수
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= current) { // 지금 나를 볼 수 없는 애들 빼기
                stack.pop();
            }
            count += stack.size();
            stack.push(current);
        }
        System.out.println(count);
    }
}
